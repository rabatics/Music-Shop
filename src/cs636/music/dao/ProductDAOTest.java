package cs636.music.dao;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cs636.music.config.MusicSystemConfig;
import cs636.music.domain.Product;

public class ProductDAOTest {
	private DbDAO dbDAO;
	private ProductDAO productdao;
	private static EntityManagerFactory emf;
	
	@BeforeClass
	public static void setUpClass() {

		emf = MusicSystemConfig.configureJPA();
	}

	@Before
	
	public void setup() throws Exception {
		dbDAO = new DbDAO(emf);
		dbDAO.startTransaction();
		dbDAO.initializeDb(); 
		dbDAO.commitTransaction();
		productdao = new ProductDAO(dbDAO);
	}

	@After
	public void tearDown() {
	
		dbDAO.rollbackAfterException();
	}
	@AfterClass
	public static void tearDownClass() throws Exception {
		MusicSystemConfig.shutdownServices();
	}

	
	@Test
	public void testFindProductByCode() throws Exception
	{
		dbDAO.startTransaction();
		Product p2 = productdao.findProductByCode("8601");
		dbDAO.commitTransaction();
		assertTrue(1 == p2.getId());
	}
}