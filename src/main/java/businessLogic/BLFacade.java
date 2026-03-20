package businessLogic;

import java.io.File;
import java.util.Date;
import java.util.List;

import domain.Erabiltzailea;
import domain.Sale;
import domain.User;
import exceptions.FileNotUploadedException;
import exceptions.MustBeLaterThanTodayException;
import exceptions.SaleAlreadyExistException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.awt.image.BufferedImage;
import java.awt.Image;

import gui.*;
/**
 * Interface that specifies the business logic.
 */
@WebService
public interface BLFacade  {
	  

	/**
	 * This method creates/adds a product to a seller
	 * 
	 * @param title of the product
	 * @param description of the product
	 * @param status 
	 * @param selling price
	 * @param category of a product
	 * @param publicationDate
	 * @return Sale
	 */
   @WebMethod
	public Sale createSale(String title, String description, int status, float price, Date pubDate, String sellerEmail, File file, String egoera) throws  FileNotUploadedException, MustBeLaterThanTodayException, SaleAlreadyExistException;
	
	
	/**
	 * This method retrieves the products that contain desc
	 * 
	 * @param desc the text to search
	 * @return collection of sales that contain desc 
	 */
	@WebMethod public List<Sale> getSales(String desc);
	
	/**
	 * 	 * This method retrieves the products that contain a desc text in a title and the publicationDate today or before
	 * 
	 * @param desc the text to search
	 * @param pubDate the date  of the publication date
	 * @return collection of sales that contain desc and published before pubDate
	 */
	@WebMethod public List<Sale> getPublishedSales(String desc, Date pubDate);

	
	/**
	 * This method calls the data access to initialize the database with some sellers and products.
	 * It is only invoked  when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
	@WebMethod public void initializeBD();
	
	@WebMethod public Erabiltzailea isLogin(String email, String password);
	
	@WebMethod public void addUser(String email, String password, String name, String telefonoa);
		
	@WebMethod public Image downloadImage(String imageName);

	@WebMethod public Erabiltzailea getUser(String email);
	
	@WebMethod public Erabiltzailea isLogin(String email);
	
	@WebMethod public void buyProduct(Sale sale, String email);
	
	@WebMethod 	public User doesAccountNumber(String zenb);
	
	@WebMethod public double getDiruKop(String zenb);
	
	@WebMethod public void updateDiruKop(String zenb, double diruKop);
	
	@WebMethod public void close();

	@WebMethod public User getUserAccounts(String userMail);
	
	@WebMethod public void updateEgoera(Sale sale, String egoera);
	
	@WebMethod 	public String getFirstAccountNumber(String email);

}