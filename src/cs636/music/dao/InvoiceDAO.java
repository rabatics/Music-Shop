package cs636.music.dao;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import cs636.music.domain.Invoice;
import cs636.music.domain.LineItem;


/**
 * 
 * Access Invoice table through this class. 

 */
public class InvoiceDAO {
	private DbDAO dbdao;
	
	/**
	 * An Data Access Object for Invoice table table
	
	 */
	public InvoiceDAO(DbDAO db) {
		dbdao = db;
	}
	

	public void insertInvoice(Invoice invoice) {
		EntityManager em = dbdao.getEM();
		em.persist(invoice);
		for (LineItem item : invoice.getLineItems())
			em.persist(item);
	}
	
	/**
	 * find all unprocessed invoice
	
	 */
	public Set<Invoice> findAllUnprocessedInvoices() {
		EntityManager em = dbdao.getEM();

		Query q = em.createNativeQuery("select * from invoice where is_processed = 'n'", Invoice.class);
		@SuppressWarnings("unchecked")
		List<Invoice> invoices = (List<Invoice>)q.getResultList();
		return new HashSet<Invoice>(invoices);
	}
	
	/**
	 * find all invoices

	 */
	public Set<Invoice> findAllInvoices() {
		EntityManager em = dbdao.getEM();
		TypedQuery<Invoice> q = 
				em.createQuery("select i from Invoice i", Invoice.class);
		List<Invoice> invoices = q.getResultList();
		return new HashSet<Invoice>(invoices);
	}
	
	/**
	 * Find an invoice by id
	
	 */
	public Invoice findInvoice(long invoiceId){
		EntityManager em = dbdao.getEM();
		Invoice invoice = em.find(Invoice.class, invoiceId);
		return invoice;
	}
}
