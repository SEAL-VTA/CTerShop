
package DAL;

import Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author levuh
 */
public class DAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Account> getAllAccount(){
        List<Account> list = new ArrayList<>();
        String query = "select * from Account_HE160841";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Account(rs.getInt(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getInt(4), 
                                    rs.getInt(5), 
                                    rs.getString(6)));
            }
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE160841";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getDouble(4), 
                                    rs.getString(5), 
                                    rs.getString(6)));
            }
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public List<Product> searchByName(String txtSearch){
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE160841 where [name] like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%"+txtSearch+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getDouble(4), 
                                    rs.getString(5), 
                                    rs.getString(6)));
            }
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public List<Product> getProductByCID(String cid){
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE160841 where cateId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getDouble(4), 
                                    rs.getString(5), 
                                    rs.getString(6)));
            }
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public Account getAccountByID(String id){
        String query = "select * from Account_HE160841 where [uID] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return(new Account(rs.getInt(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getInt(4), 
                                    rs.getInt(5), 
                                    rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Product getProductByID(String id){
        String query = "select * from Product_HE160841 where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return(new Product(rs.getInt(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getDouble(4), 
                                    rs.getString(5), 
                                    rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Product getProduct(String id){
        String query = "select * from Product_HE160841 where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return(new Product(rs.getInt(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getDouble(4), 
                                    rs.getString(5), 
                                    rs.getString(6),
                                    1));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String query = "select * from Category_HE160841";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        
        return list;
    }
    
    public Product getLast(){
        String query = "select top 1 * from Product_HE160841\n" +
                        "order by id desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getDouble(4), 
                                    rs.getString(5), 
                                    rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Account login(String user, String pass){
        String query = "select * from Account_HE160841\n" +
                        "where [user] = ? and pass = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1), 
                                rs.getString(2), 
                                rs.getString(3), 
                                rs.getInt(4), 
                                rs.getInt(5),
                                rs.getString(6));
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public Account checkUserNameExist(String user){
        String query = "select * from Account_HE160841\n" +
                        "where [user] = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1), 
                                rs.getString(2), 
                                rs.getString(3), 
                                rs.getInt(4), 
                                rs.getInt(5),
                                rs.getString(6));
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    public Account checkEmailExist(String email){
        String query = "select * from Account_HE160841\n" +
                        "where email = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1), 
                                rs.getString(2), 
                                rs.getString(3), 
                                rs.getInt(4), 
                                rs.getInt(5),
                                rs.getString(6));
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public void resetPass(String newPass, String email){
        String query = "update Account_HE160841 set pass = ? where email = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, newPass);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void signup(String user, String pass, String email){
        String query = "insert into Account_HE160841 values(?,?,0,0,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deleteAccount(String uid){
        String query = "delete from Account_HE160841 where uID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, uid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deleteProduct(String pid){
        String query = "delete from Product_HE160841 where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void addProduct(String name, String image, String price, 
            String title, String description, String category, int sid){
        String query = "INSERT [dbo].[Product_HE160841] ([name], [image], [price], [title], [description], [cateId], [sell_Id]) \n" +
                        "VALUES (?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, sid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void editAccount(String user, String pass, String isSell, String isAdmin, String email, String uid){
        String query = "update Account_HE160841 set [user] = ?, \n" +
"                        pass = ?, \n" +
"                        isSell = ?, \n" +
"                        isAdmin = ?,\n" +
"                        email = ? where [uID] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, isSell);
            ps.setString(4, isAdmin);
            ps.setString(5, email);
            ps.setString(6, uid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void editProduct(String name, String image, String price, 
            String title, String description, String category, String pid){
        String query = "update Product_HE160841 \n" +
                        "set [name] = ?,\n" +
                        "[image] = ?,\n" +
                        "price = ?,\n" +
                        "title = ?,\n" +
                        "[description] = ?,\n" +
                        "cateId = ? where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public int getTotalAccount(){
        String query = "select count(*) from Account_HE160841";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        
        return 0;
    }
    
    public int getTotalProduct(){
        String query = "select count(*) from Product_HE160841";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        
        return 0;
    }
    
    public List<Account> pagingAccount(int index){
        List<Account> list = new ArrayList<>();
        String query = "select * from Account_HE160841\n"
                + "order by uID\n"
                + "offset ? rows fetch next 5 rows only;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index-1)*5);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Account(rs.getInt(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getInt(4), 
                                    rs.getInt(5), 
                                    rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Product> pagingProduct(int id, int index){
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE160841 where sell_Id = ?\n"
                + "order by id\n"
                + "offset ? rows fetch next 5 rows only;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, (index-1)*5);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getDouble(4), 
                                    rs.getString(5), 
                                    rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Product> getAllProduct(int index){
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE160841\n"
                + "order by id\n"
                + "offset ? rows fetch next 6 rows only;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index-1)*6);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getDouble(4), 
                                    rs.getString(5), 
                                    rs.getString(6)));
            }
        } catch (Exception e) {
        }
        
        return list;
    }
    
//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        
//        List<Category> list = dao.getProductByCID(cid);
//        for (Category o : list) {
//            System.out.println(o);
//        }
//    }
}
