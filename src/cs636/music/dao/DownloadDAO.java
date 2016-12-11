
package cs636.music.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cs636.music.domain.Download;

/**
 * 
 * Access Download table through this class. 

 */
public class DownloadDAO {
	
	private DbDAO dbdao;

	/**
	 * An Data Access Object for Download table

	 */
	public DownloadDAO(DbDAO db ){
		dbdao = db;
	}

	/**

	
	 */
	public void insertDownload(Download download) {
		EntityManager em = dbdao.getEM();
		em.persist(download);
	}
	
	
	/**
	 * find all downloads
	
	 */
	public Set<Download> findAllDownloads() {
		EntityManager em = dbdao.getEM();
		TypedQuery<Download> q = em.createQuery("select d from Download d", Download.class);
		List<Download> downloads = q.getResultList();
		Set<Download> downloadSet = new HashSet<Download>(downloads);
		return downloadSet;
	}
}
