package cs636.music.service;

import java.util.Set;

import cs636.music.dao.AdminDAO;
import cs636.music.dao.DbDAO;
import cs636.music.dao.DownloadDAO;
import cs636.music.dao.InvoiceDAO;
import cs636.music.domain.Download;
import cs636.music.domain.Invoice;
import cs636.music.domain.LineItem;


public class AdminService implements AdminServiceAPI {
	
	private DbDAO db;
	private DownloadDAO downloadDb;
	private InvoiceDAO invoiceDb;
	private AdminDAO adminDb;
	

	public AdminService(DbDAO dbDao, DownloadDAO downloadDao ,InvoiceDAO invoiceDao, AdminDAO adminDao) {
		db = dbDao;
		downloadDb = downloadDao;
		invoiceDb = invoiceDao;
		adminDb = adminDao;
		
	}
	
	/**
	 * Clean all user table, not product and system table to empty
	 * and then set the index numbers back to 1
	 * @throws ServiceException
	 */
	public void initializeDB()throws ServiceException {
		try {
			db.startTransaction();
			db.initializeDb();
			db.commitTransaction();
		} catch (Exception e) { // any exception
			
			db.rollbackAfterException();
			throw new ServiceException(
					"Can't initialize DB: (probably need to load DB)", e);
		}
	}
	
	/**
	 * process the invoice

	 */
	public void processInvoice(long invoice_id) throws ServiceException {
		try {
			db.startTransaction();
			Invoice invoice = invoiceDb.findInvoice(invoice_id);
			invoice.setIsProcessed("y");
			db.commitTransaction();
		} catch (Exception e)
		{
			db.rollbackAfterException();
			throw new ServiceException("Invoice was not processed successfully: ",
					e);
		}
	}

	/**
	 * Get a list of all invoices, including line items and user details

	 */
	public Set<Invoice> getListofInvoices() throws ServiceException {
		try {
			db.startTransaction();
			Set<Invoice> invoices = invoiceDb.findAllInvoices();
			
			for (Invoice invoice : invoices) {
				for (LineItem li : invoice.getLineItems())
					li.getQuantity();
			}
			db.commitTransaction();
			return invoices;
		} catch (Exception e)
		{
			db.rollbackAfterException();
			throw new ServiceException("Can't find invoice list: ", e);
		}
	}
	
	/**
	 * Get a list of all unprocessed invoices, no details
	
	 */
	public Set<Invoice> getListofUnprocessedInvoices() throws ServiceException {
		try {
			db.startTransaction();
			Set<Invoice> invoices = invoiceDb.findAllUnprocessedInvoices();
			db.commitTransaction();
			return invoices;
		} catch (Exception e)
		{
			db.rollbackAfterException();
			throw new ServiceException("Can't find unprocessed invoice list: ", e);
		}
	}
	
	/**
	 * Get a list of all downloads, including track, product, and user details

	 */
	public Set<Download> getListofDownloads() throws ServiceException {
		try {
			db.startTransaction();
			Set<Download> downloads = downloadDb.findAllDownloads();
			// track is to-one, then its Product is to-one
			// related user is to-one, so all eagerly loaded by default
			db.commitTransaction();
			return downloads;
			
		} catch (Exception e)
		{
			db.rollbackAfterException();
			throw new ServiceException("Can't find download list: ", e);
		}
	}
	
	
	/**
	 * Check login user
	
	 */
	public Boolean checkLogin(String username,String password) throws ServiceException {
		try {
			db.startTransaction();
			Boolean b = adminDb.findAdminUser(username, password);
			db.commitTransaction();
			return b;
		} catch (Exception e)
		{
			db.rollbackAfterException();
			throw new ServiceException("Check login error: ", e);
		}
	}
	
}
