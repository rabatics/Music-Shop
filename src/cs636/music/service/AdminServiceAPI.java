package cs636.music.service;

import java.util.Set;

import cs636.music.domain.Download;
import cs636.music.domain.Invoice;

public interface AdminServiceAPI {

	public void initializeDB() throws ServiceException;
	
	/**
	 * process the invoice

	 */	
	public void processInvoice(long invoice_id) throws ServiceException;
	
	/**
	 * Get a list of all invoices, including line items and user details

	 */
	
	public Set<Invoice> getListofInvoices() throws ServiceException;
	/**
	 * Get a list of all unprocessed invoices, no details
	 
	 */
	public Set<Invoice> getListofUnprocessedInvoices() throws ServiceException;
	
	/**
	 * Get a list of all downloads, including track, product, and user details

	 */
	public Set<Download> getListofDownloads() throws ServiceException;
	
	/**
	 * Check login user
	
	 */
	public Boolean checkLogin(String username,String password) throws ServiceException;
}
