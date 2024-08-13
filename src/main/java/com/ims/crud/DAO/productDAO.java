package com.ims.crud.DAO;

import java.util.List;


import org.hibernate.Session;

import org.hibernate.Transaction;

import com.ims.crud.configs.dbConnection;
import com.ims.crud.models.Inventory;
import com.ims.crud.models.Product;

public class productDAO {

	public static void insertProduct(Product product) {
		try (Session session = dbConnection.initDatabase()) {
			session.beginTransaction();
			
			

			session.save(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static List<Product> fetchAllProducts() {
		try (Session session = dbConnection.initDatabase()) {

			session.beginTransaction();
			List<Product> result = session.createQuery(dbConnection.HQL_SELECT_ALL_PRODUCTS, Product.class).list();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public static boolean updateProductRecord(Product productWithUpdatedDetails,int productQuantity, int updateId) {
		try (Session session = dbConnection.initDatabase()){
			session.beginTransaction();
			
			Product product = session.get(Product.class, updateId);

            if (product != null) {
                product.setProductName(productWithUpdatedDetails.getProductName());
                product.setCategory(productWithUpdatedDetails.getCategory());

                Inventory inventory = product.getInventory();
                if (inventory != null) {
                    inventory.setQuantity(productQuantity);
                } else {
                    inventory = new Inventory();
                    inventory.setQuantity(productQuantity);
                    inventory.setProduct(product);
                    product.setInventory(inventory);
                }

                session.saveOrUpdate(product);
                
                session.getTransaction().commit();
                
                return true;
            } else {
            	return false;
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}

	public static boolean deleteProductRecord(int deleteId) {
		try (Session session = dbConnection.initDatabase()) {
			session.beginTransaction();
			Product p = findProductById(deleteId);
			session.delete(p);
			session.getTransaction().commit();

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public static Product findProductById(int productId) {
		try (Session session = dbConnection.initDatabase()) {
			session.beginTransaction();
			Product productToBeUpdated = session.find(Product.class, productId);
			return productToBeUpdated;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public static Product findProductByName(String productName) {
		try (Session session = dbConnection.initDatabase()) {
			session.beginTransaction();
			Product product = session.find(Product.class, productName);
			return product;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
