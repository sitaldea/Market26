package dataAccess;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import configuration.ConfigXML;
import configuration.UtilDate;
import domain.User;
import domain.Sale;
import exceptions.FileNotUploadedException;
import exceptions.MustBeLaterThanTodayException;
import exceptions.SaleAlreadyExistException;

/**
 * It implements the data access to the objectDb database
 */
public class DataAccess  {
	private  EntityManager  db;
	private  EntityManagerFactory emf;
    private static final int baseSize = 160;

	private static final String basePath="src/main/resources/images/";



	ConfigXML c=ConfigXML.getInstance();

     public DataAccess()  {
		String fileName = c.getDbFilename();
		File dbFile = new File(fileName);
		boolean exists = dbFile.exists();
		open();

		if (c.isDatabaseInitialized()) {
			if (!exists) {
				initializeDB();
			} else {
				System.out.println("Database file already exists; skipping initialization.");
			}
		}

		System.out.println("DataAccess created => isDatabaseLocal: "+c.isDatabaseLocal()+" isDatabaseInitialized: "+c.isDatabaseInitialized());

		close();

		}

    public DataAccess(EntityManager db) {
     this.db=db;
    }

	
	
	/**
	 * This method  initializes the database with some products and sellers.
	 * This method is invoked by the business logic (constructor of BLFacadeImplementation) when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
	public void initializeDB(){
		
		db.getTransaction().begin();

		try { 
	       
		    //Create sellers 
			User seller1=new User("seller1@gmail.com", "Aitor Fernandez", "1234", "666666666");
			User seller2=new User("seller22@gmail.com", "Ane Gaztañaga", "1234", "655555555");
			User seller3=new User("seller3@gmail.com", "Test Seller", "1234", "644444444");
			
			seller1.addDiruKontua("ES45678923245", 1000);
			seller1.addDiruKontua("ES37848898695", 5);
			seller2.addDiruKontua("ES09245762456", 20);
			seller3.addDiruKontua("ES44764463247", 453);

			
			//Create products
			Date today = UtilDate.trim(new Date());
		
			
			seller1.addSale("futbol baloia", "oso polita, gutxi erabilita", 10, 2,  today, null);
			seller1.addSale("salomon mendiko botak", "44 zenbakia, 3 ateraldi",20,  2,  today, null);
			seller1.addSale("samsung 42\" telebista", "berria, erabili gabe", 175, 1,  today, null);


			seller2.addSale("imac 27", "7 urte, dena ondo dabil", 1, 200,today, null);
			seller2.addSale("iphone 17", "oso gutxi erabilita", 2, 400, today, null);
			seller2.addSale("orbea mendiko bizikleta", "29\" 10 urte, mantenua behar du", 3,225, today, null);
			seller2.addSale("polar kilor erlojua", "Vantage M, ondo dago", 3, 30, today, null);

			seller3.addSale("sukaldeko mahaia", "1.8*0.8, 4 aulkiekin. Prezio finkoa", 3,45, today, null);

			
			db.persist(seller1);
			db.persist(seller2);
			db.persist(seller3);

	
			db.getTransaction().commit();
			System.out.println("Db initialized");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method creates/adds a product to a seller
	 * 
	 * @param title of the product
	 * @param description of the product
	 * @param status 
	 * @param selling price
	 * @param category of a product
	 * @param publicationDate
	 * @return Product
 	 * @throws SaleAlreadyExistException if the same product already exists for the seller
	 */
	public Sale createSale(String title, String description, int status, float price,  Date pubDate, String sellerEmail, File file) throws  FileNotUploadedException, MustBeLaterThanTodayException, SaleAlreadyExistException {
		

		System.out.println(">> DataAccess: createProduct=> title= "+title+" seller="+sellerEmail);
		try {
		

			if(pubDate.before(UtilDate.trim(new Date()))) {
				throw new MustBeLaterThanTodayException(ResourceBundle.getBundle("Etiquetas").getString("DataAccess.ErrorSaleMustBeLaterThanToday"));
			}
			if (file==null)
				throw new FileNotUploadedException(ResourceBundle.getBundle("Etiquetas").getString("DataAccess.ErrorFileNotUploadedException"));

			db.getTransaction().begin();
			
			User seller = db.find(User.class, sellerEmail);
			if (seller.doesSaleExist(title)) {
				db.getTransaction().commit();
				throw new SaleAlreadyExistException(ResourceBundle.getBundle("Etiquetas").getString("DataAccess.SaleAlreadyExist"));
			}

			Sale sale = seller.addSale(title, description, status, price, pubDate, file);
			//next instruction can be obviated

			db.persist(seller); 
			db.getTransaction().commit();
			 System.out.println("sale stored "+sale+ " "+seller);

			

			   System.out.println("hasta aqui");

			return sale;
		} catch (NullPointerException e) {
			   e.printStackTrace();
			// TODO Auto-generated catch block
			db.getTransaction().commit();
			return null;
		}
		
		
	}
	
	/**
	 * This method retrieves all the products that contain a desc text in a title
	 * 
	 * @param desc the text to search
	 * @return collection of products that contain desc in a title
	 */
	public List<Sale> getSales(String desc) {
	    System.out.println(">> DataAccess: getProducts=> from= "+desc);

	    TypedQuery<Sale> query = db.createQuery(
	        "SELECT s FROM User u JOIN u.sales s WHERE s.title LIKE ?1",
	        Sale.class
	    );   
	    query.setParameter(1, "%"+desc+"%");
	    
	    List<Sale> sales = query.getResultList();
	    return sales;
	}
	
	/**
	 * This method retrieves the products that contain a desc text in a title and the publicationDate today or before
	 * 
	 * @param desc the text to search
	 * @return collection of products that contain desc in a title
	 */
	public List<Sale> getPublishedSales(String desc, Date pubDate) {
	    System.out.println(">> DataAccess: getProducts=> from= "+desc);
	    TypedQuery<Sale> query = db.createQuery(
	        "SELECT s FROM User u JOIN u.sales s WHERE s.title LIKE ?1 AND s.pubDate <=?2",
	        Sale.class
	    );
	    query.setParameter(1, "%"+desc+"%");
	    query.setParameter(2, pubDate);

	    List<Sale> sales = query.getResultList();
	    return sales;
	}

public void open(){
		
		String fileName=c.getDbFilename();
		if (c.isDatabaseLocal()) {
			emf = Persistence.createEntityManagerFactory("objectdb:"+fileName);
			db = emf.createEntityManager();
		} else {
			Map<String, String> properties = new HashMap<String, String>();
			  properties.put("javax.persistence.jdbc.user", c.getUser());
			  properties.put("javax.persistence.jdbc.password", c.getPassword());

			  emf = Persistence.createEntityManagerFactory("objectdb://"+c.getDatabaseNode()+":"+c.getDatabasePort()+"/"+fileName, properties);
			  db = emf.createEntityManager();
    	   }
		System.out.println("DataAccess opened => isDatabaseLocal: "+c.isDatabaseLocal());

		
	}

	public BufferedImage getFile(String fileName) {
		File file=new File(basePath+fileName);
		BufferedImage targetImg=null;
		try {
             targetImg = rescale(ImageIO.read(file));
        } catch (IOException ex) {
            //Logger.getLogger(MainAppFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
		return targetImg;

	}
	
	public BufferedImage rescale(BufferedImage originalImage)
    {
		System.out.println("rescale "+originalImage);
        BufferedImage resizedImage = new BufferedImage(baseSize, baseSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, baseSize, baseSize, null);
        g.dispose();
        return resizedImage;
    }
	
	public User isLogin(String email, String password) {
		TypedQuery<User> query = db.createQuery("SELECT u FROM User u WHERE u.email=?1 AND u.password=?2", User.class);   
		query.setParameter(1, email);
		query.setParameter(2, password);
		if(!query.getResultList().isEmpty()) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
		
	}
	
	public User isLogin(String email) {
		TypedQuery<User> query = db.createQuery("SELECT u FROM User u WHERE u.email=?1", User.class);   
		query.setParameter(1, email);
		if(!query.getResultList().isEmpty()) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
		
	}
	
	
	
	public void close(){
		try {
			if (db != null && db.isOpen()) {
				if (db.getTransaction().isActive()) {
					try {
						db.getTransaction().commit();
					} catch (Exception ex) {
						try { db.getTransaction().rollback(); } catch (Exception e) { /* ignore */ }
					}
				}
				db.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (emf != null && emf.isOpen()) {
				emf.close();
			}
		}
		System.out.println("DataAccess closed");
	}

	public void addUser(String email, String password, String name, String telefonoa) {
     	db.getTransaction().begin();
		User user = new User(email, name, password, telefonoa);
		db.persist(user);
		db.getTransaction().commit();		
	}
	
	public User getUser(String email) {
		TypedQuery<User> query = db.createQuery("SELECT u FROM User u WHERE u.email=?1", User.class);   
		query.setParameter(1, email);
		if(!query.getResultList().isEmpty()) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
		
	}

	public boolean buyProduct(Sale sale, String kontuZenb, String email) {
	    try {
	        db.getTransaction().begin();
	        Sale managedSale = db.find(Sale.class, sale.getSaleNumber());
	        User buyer = db.find(User.class, email);
	        User seller = managedSale.getSeller();
	        double diruKop = getDiruKop(kontuZenb);
	        if (diruKop >= managedSale.getPrice()) {
	            buyer.updateDiruKop(kontuZenb, diruKop - managedSale.getPrice());
	            seller.getSales().remove(managedSale);
	            buyer.getErositakoak().add(managedSale);
	            db.persist(buyer);
	            db.persist(seller);
	            db.getTransaction().commit();
	            return true;
	        } else {
	            // Not enough funds: no state change
	            db.getTransaction().commit();
	            return false;
	        }
	    } catch (Exception e) {
	        if (db.getTransaction().isActive()) {
	            try { db.getTransaction().rollback(); } catch (Exception ex) { /* ignore */ }
	        }
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public User doesAccountNumber(String zenb) {
	    TypedQuery<User> query = db.createQuery("SELECT u FROM User u JOIN u.kontuak d WHERE d.kontuZenb = ?1", User.class);
	    query.setParameter(1, zenb);
	    List<User> result = query.getResultList();
	    if (!result.isEmpty()) {
	        return result.get(0);
	    } else {
	        return null;
	    }
	}
	
	public double getDiruKop(String zenb) {
	    TypedQuery<Double> query = db.createQuery("SELECT d.diruKop FROM User u JOIN u.kontuak d WHERE d.kontuZenb = ?1", Double.class);
	    query.setParameter(1, zenb);
	    List<Double> result = query.getResultList();
	    if (!result.isEmpty()) {
	        return result.get(0);
	    } else {
	        return 0;
	    }
	}
	
	public void updateDiruKop(String zenb, double diruKop) {
		User u = doesAccountNumber(zenb);
		if(u!=null) {
			u.updateDiruKop(zenb, diruKop);
			db.persist(u);
		}
	}
	
	public void addErositakoak(Sale sale, String email) {
		User u = getUser(email);
		if(u!=null) {
			u.getErositakoak().add(sale);
			db.persist(u);
		}
	}
}
