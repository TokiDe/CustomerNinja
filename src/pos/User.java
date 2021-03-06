package pos;

import java.sql.ResultSet;
import java.sql.*;
import javafx.beans.property.SimpleStringProperty;

public class User {
        
        private int id;
	private String name;
	private String address;
	private int salesNum;
	private double salesVal;
	private int permissions;
	private String username;
	//private NinjaConn njc;
	private ResultSet rSet;
	private final String table = "tbUSERS";
        
        private SimpleStringProperty idP;
        private SimpleStringProperty nameP;
        private SimpleStringProperty addressP;
        private SimpleStringProperty salesNumP;
        private SimpleStringProperty salesValP;
        private SimpleStringProperty permissionsP;
        private SimpleStringProperty usernameP;
	
	public User(int id) {
            NinjaConn njc = new NinjaConn();
            this.id = id;
            //this.njc = njc;
            //rSet = null;
            try {

            rSet = njc.quID(this.id, this.table);
            name = rSet.getString("name");
            address = rSet.getString("address");
            salesNum = rSet.getInt("sales");		
            salesVal = rSet.getDouble("sales_val");
            username = rSet.getString("username");
            permissions = rSet.getInt("permissions");

            idP = new SimpleStringProperty(Integer.toString(this.id));
            nameP = new SimpleStringProperty(name);
            addressP = new SimpleStringProperty(address);
            salesNumP = new SimpleStringProperty(Integer.toString(salesNum));
            salesValP = new SimpleStringProperty(Double.toString(salesVal));
            permissionsP = new SimpleStringProperty(Integer.toString(permissions));
            usernameP = new SimpleStringProperty(username);

            } catch (Exception ex) {
                    System.out.println("User Construct Fail!  " + ex.toString() );
            } finally {
                njc.close();
            }
	}
	
	public User(String uname) {
            NinjaConn njc = new NinjaConn();
            this.username = uname;
            //this.njc = njc;
            //rSet = null;
            try {
                rSet = njc.quUname(this.username, this.table);
                id = rSet.getInt("id");
                name = rSet.getString("name");
                address = rSet.getString("address");
                salesNum = rSet.getInt("sales");		
                salesVal = rSet.getDouble("sales_val");
                username = rSet.getString("username");
                permissions = rSet.getInt("permissions");
                
                idP = new SimpleStringProperty(Integer.toString(id));
                nameP = new SimpleStringProperty(name);
                addressP = new SimpleStringProperty(address);
                salesNumP = new SimpleStringProperty(Integer.toString(salesNum));
                salesValP = new SimpleStringProperty(Double.toString(salesVal));
                permissionsP = new SimpleStringProperty(Integer.toString(permissions));
                usernameP = new SimpleStringProperty(this.username);

                } catch (Exception ex) {
                        System.out.println("User Construct Fail!  " + ex.toString() );
                } finally {
                    njc.close();
                }
	}
	
	protected int getID() {
		
		return id;
		
	}
	
	protected String getName() {
		
		return name;
		
	}
	
	protected String getAddress() {
		
		return address;
		
	}
	
	protected int getSalesNum() {
		
		return salesNum;
		
	}

	protected double getSalesVal() {
		
		return salesVal;
		
	}
	
	protected int getPermissions() {
		
		return permissions;
		
	}
	
	protected String getUsername() {
		
		return username;
		
	}
	
	protected void setName(String newName) {
		NinjaConn njc = new NinjaConn();	
		name = newName;
		njc.updateDBString(this.table, "name", newName, this.id);
                njc.close();
	}

	protected void setAddress(String newAddr) {
		NinjaConn njc = new NinjaConn();	
		address = newAddr;
		njc.updateDBString(this.table, "address", newAddr, this.id);
                njc.close();
	}

	protected void setSalesNum(int newSalesNum) {
		NinjaConn njc = new NinjaConn();	
		salesNum = newSalesNum;
		njc.updateDBInt(this.table, "sales", newSalesNum, this.id);
	        njc.close();	
	}
	
	protected void setSalesVal(double newSalesVal) {
		NinjaConn njc = new NinjaConn();	
		salesVal = newSalesVal;
		njc.updateDBDouble(this.table, "sales_val", this.salesVal, this.id);
	        njc.close();	
	}
	
	protected void setPermissions(int newPermissions) {
		NinjaConn njc = new NinjaConn();	
                if (this.permissions == 1) {
                    permissions = newPermissions;
                    njc.updateDBInt(this.table, "permissions", newPermissions, this.id);
                }
	        njc.close();	
	}
	
	protected void setUsername(String newUsername) {
		NinjaConn njc = new NinjaConn();	
                if (this.permissions == 1) {
                    username = newUsername;
                    njc.updateDBString(this.table, "username", newUsername, this.id);
                }
                njc.close();        
	}
        
        public String getIdP() {
            return idP.get();
        }
        
        public String getNameP() {
            return nameP.get();
        }
	
        public String getAddressP() {
            return addressP.get();
        }
        
        public String getSalesNumP() {
            return salesNumP.get();
        }
        
        public String getSalesValP() {
            return salesValP.get();
        }
        
        public String getPermissionsP() {
            return permissionsP.get();
        }
        
        public String getUsernameP() {
            return usernameP.get();
        }
	
} //end User