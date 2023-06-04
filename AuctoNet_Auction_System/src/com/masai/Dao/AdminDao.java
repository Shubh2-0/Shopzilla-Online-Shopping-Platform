package com.masai.Dao;


import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import com.masai.Dto.ProductImpl;
import com.masai.Dto.SellerImpl;
import com.masai.Dto.TransactionImpl;
import com.masai.Exceptions.InvalidCredentialsException;
import com.masai.Exceptions.RecordNotFoundException;

public interface AdminDao {
	
	Boolean loginAdmin(String adminId, String password) throws InvalidCredentialsException;
    ResultSet getAllBuyer()throws RecordNotFoundException;
    ResultSet getAllSeller()throws RecordNotFoundException;
    ResultSet getAllProducts()throws RecordNotFoundException;
    ResultSet getAllSoldProducts()throws RecordNotFoundException;
    ResultSet getAllProductsByCategory(String CatName) throws RecordNotFoundException;
    ResultSet getAllTransaction()throws RecordNotFoundException;
    ResultSet getAllTransactionbyDateRange(LocalDate startDate,LocalDate endDate)throws RecordNotFoundException;
    ResultSet getTransactionById(int id)throws RecordNotFoundException;
	ResultSet getAllProductsBySellerId(String CatName) throws RecordNotFoundException;
	ResultSet getAllProductsByInAccendingOrderByPrice() throws RecordNotFoundException;
	ResultSet getAllProductsByQuantity(int from, int to) throws RecordNotFoundException;
	ResultSet getAllTransactionByQuantity() throws RecordNotFoundException;
	ResultSet getAllTransactionByGSTPercentage() throws RecordNotFoundException;
	ResultSet getAllTransactionByTotalPrice() throws RecordNotFoundException;
	ResultSet getAllTransactionByPurchaseDate() throws RecordNotFoundException;


}
