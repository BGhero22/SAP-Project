import java.sql.*;
import java.util.*;

public class SQLConnector {
    public void addChannel(Connection con, String name, float price,int contract_id,int category_id)  {
        try{
            PreparedStatement pst = con.prepareStatement("insert into chanels(name, price,contract_id,category_id) values(?,?,?,?);");
            pst.setString(1, name);
            pst.setFloat(2, price);
            pst.setInt(3,contract_id);
            pst.setInt(4,category_id);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void addCategory(Connection con, String name, float price) {
        try{
            PreparedStatement pst = con.prepareStatement("insert into categories(name,price) values(?,?);");
            pst.setString(1, name);
            pst.setFloat(2, price);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void addContracts(Connection con,  float value, String numberofContract, int lenght, int deliver_id)  {
        try{
            PreparedStatement pst = con.prepareStatement("insert into contracts(price,numberofContract,lenght_in_months,deliver_id) values(?,?,?,?);");
            pst.setFloat(1,value);
            pst.setString(2, numberofContract);
            pst.setInt(3, lenght);
            pst.setInt(4, deliver_id);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void addClients(Connection con, String name, String password, String email, String egn, int package_id)
    {
        try{
           PreparedStatement pst = con.prepareStatement("insert into TV_Operator.clients(username,email,pass,egn,package_id) values(?,?,?,?,?);");
           pst.setString(1, name);
           pst.setString(2, email);
           pst.setString(3, password);
           pst.setString(4, egn);
           pst.setInt(5, package_id);
           pst.executeUpdate();
       }
       catch (SQLException e){
           System.out.println(e.getMessage());
       }

    }


    public void addDelivers(Connection con, String name)  {
        try{
            PreparedStatement pst = con.prepareStatement("insert into delivers (name) values(?)");
            pst.setString(1, name);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void addPackages(Connection con)  {

        try {
            PreparedStatement pst = con.prepareStatement("insert into packages(price) values(?); ");
            pst.setFloat(1, 0.00F);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public int getkey(Connection con)  {
        ResultSet rs;
        int id = 0;
        try{
            PreparedStatement pst=con.prepareStatement("Select count(id) as rowscount from packages;");
            rs=pst.executeQuery();
             while(rs.next()){
                id=rs.getInt("rowscount");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return id;
    }

    public void updateChannelsname(Connection con,String old_name)  {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter new name for channel");
        String new_name=sc.nextLine();
        try{
            PreparedStatement pst = con.prepareStatement("update chanels  set name=? where name=?;");
            pst.setString(1, new_name);
            pst.setString(2,old_name);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void updateChannelsprice(Connection con, float price)  {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name of channel you want to update;");
        String name=sc.nextLine();
        try {
            PreparedStatement pst = con.prepareStatement("update chanels  set price=? where name=?;");
            pst.setFloat(1, price);
            pst.setString(2,name);
            pst.executeUpdate();
        }
       catch (SQLException e){
           System.out.println(e.getMessage());
       }
    }

    public void updateCategoryprice(Connection con, float price)  {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name of category you want to update;");
        String name=sc.nextLine();
        try{
            PreparedStatement pst = con.prepareStatement("update categories  set price=? where name=?;");
            pst.setFloat(1, price);
            pst.setString(2,name);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void updateContractlenght(Connection con, int lenght,String number)  {
        try{
            PreparedStatement pst = con.prepareStatement("update contracts  set lenght_in_months=? where numberofContract=?;");
            pst.setInt(1, lenght);
            pst.setString(2,number);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void updateClientname(Connection con, String egn)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter new name ");
        String name=sc.nextLine();
        try{
            PreparedStatement pst = con.prepareStatement("update clients  set username=? where egn=?;");
            pst.setString(1, name);
            pst.setString(2,egn);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void updateClientpass(Connection con, String egn)  {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter new password");
        String password=sc.nextLine();
        try{

            PreparedStatement pst = con.prepareStatement("update clients  set pass=? where egn=?;");
            pst.setString(1, password);
            pst.setString(2,egn);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void updateClientmail(Connection con, String egn)  {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter new mail");
        String mail=sc.nextLine();
        try{
            PreparedStatement pst = con.prepareStatement("update clients  set mail=? where egn=?;");
            pst.setString(1, mail);
            pst.setString(2,egn);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void updatepackageprice(Connection con, float price,int id)  {
        try{
            PreparedStatement pst = con.prepareStatement("update packages  set price=? where id=?;");
            pst.setFloat(1, price);
            pst.setInt(2,id);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }


    public void updateDeliver(Connection con,String old_name)  {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter new name for deliver");
        String new_name=sc.nextLine();
        try{
            PreparedStatement pst = con.prepareStatement("update delivers set name=? where name=?;");
            pst.setString(1,new_name);
            pst.setString(2,old_name);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void deleteChannels(Connection con,String name) {
        try{
            PreparedStatement pst = con.prepareStatement("Delete from chanels where name=?");
            pst.setString(1,name);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void deleteCategory(Connection con,String name)  {
        try{
            PreparedStatement pst = con.prepareStatement("Delete  from categories where name=?");
            pst.setString(1,name);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteContracts(Connection con,String number)  {
        try {
            PreparedStatement pst = con.prepareStatement("Delete from contracts where numberofContract=?;");
            pst.setString(1,number);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void deleteClients(Connection con,String name) {
        try{
            PreparedStatement pst = con.prepareStatement("Delete from clients where username=?;");
            pst.setString(1,name);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteDelivers(Connection con,String name)  {
       try{
           PreparedStatement pst = con.prepareStatement("Delete from delivers where name=?;");
           pst.setString(1,name);
           pst.executeUpdate();
       }
       catch (SQLException e){
           System.out.println(e.getMessage());
       }

    }

    public void deletePackages(Connection con,int id) {
        try{
            PreparedStatement pst = con.prepareStatement("Delete from packages where id=?;");
            pst.setInt(1,id);
            pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }


    public String lookforuser(Connection con, String s, String username)  {
        ResultSet x ;
        String usercheck = " ";
        try {
            CallableStatement pst = con.prepareCall("Call regornot(?,?);");
            pst.setString(1,username);
            pst.setString(2,usercheck);
            x = pst.executeQuery();



            while (x.next()) {
                usercheck = (String.format("%s", x.getString("username")));
                if(usercheck.equals(username)){
                    break;
                }
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            }
        return usercheck;
    }

    public void  allChannels(Connection con)  {
        ResultSet rs;
        try{
            PreparedStatement pst=con.prepareStatement("Select * from chanels;");
            rs=pst.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String chan=rs.getString("name");
                System.out.print(id);
                System.out.println(" "+chan);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

public String getChannel(Connection con, String chan)  {
        String haveornot=" ";
        try{
            CallableStatement pst=con.prepareCall("{Call chanintopackage(?)}");
            pst.setString(1,chan);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
                haveornot=(String.format("%S",rs.getString("name")));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return haveornot;
    }
    public String getChannelById(Connection con,int id){
        Scanner sc=new Scanner(System.in);
        ResultSet rs;
        System.out.println("Re enter wanted channel name");
        String flagname=sc.nextLine();
        String chan = "";
        try{
            PreparedStatement pst=con.prepareStatement("Select name from chanels where id=?;");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
                chan=rs.getString("name");
                if(chan.equals(flagname)){
                    break;
                }

                System.out.println(chan);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return chan;

    }

    public int incatornot(Connection con,String chan,int id) {
        ResultSet rs;
        int flag = 0;
        List<String> catts = new ArrayList<>();
        try{
            PreparedStatement pst= con.prepareStatement("Select name\n" +
                    "from  categories \n" +
                    "join package_category \n" +
                    "on categories.id = package_category.category_id\n" +
                    "where tv_operator.package_category.package_id = ?;");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
                String catt=rs.getString("name");
                catts.add(catt);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        String[] arrCats=catts.toArray(new String[catts.size()]);
        for(int i=0;i<arrCats.length;i++){
            try {
                PreparedStatement pst = con.prepareStatement("Select chanels.name from chanels\n" +
                        "join chanel_category on chanels.id=chanel_category_id\n" +
                        "join categories on categories.name=?;");
                pst.setString(1,arrCats[i]);
                ResultSet x = pst.executeQuery();
                while (x.next()) {
                    String chanel = x.getString("name");
                    if (chan.equals(chanel)){
                        flag = 1;
                        break;
                    }

                }
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return flag;
    }

    public String getCategory(Connection con, String categ)  {
        String haveornot=" ";
        try{
            CallableStatement pst=con.prepareCall("{Call categtopackage(?)}");
            pst.setString(1,categ);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
                haveornot=(String.format("%S",rs.getString("name")));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return haveornot;
    }

    public String getCategoryById(Connection con,int id){
        Scanner sc=new Scanner(System.in);
        ResultSet rs;
        System.out.println("Re enter wanted category name");
        String flagname=sc.nextLine();
        String categ = "";
        try{
            PreparedStatement pst=con.prepareStatement("Select name from categories where id=?;");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
                categ=rs.getString("name");
                if(categ.equals(flagname)){
                    break;
                }

                System.out.println(categ);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return categ;

    }

    public int catinpack(Connection con,String categ,int id)  {
        ResultSet rs;
        int flag=0;
        try{
            PreparedStatement pst= con.prepareStatement("Select name\n" +
                    "from  categories \n" +
                    "join package_category \n" +
                    "on categories.id = package_category.category_id\n" +
                    "where tv_operator.package_category.package_id = ?;");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while (rs.next()){
                String name=rs.getString("name");
                if(categ.equals(name)){
                    flag=1;
                    break;
                }
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return flag;
    }

    public float getPriceOfCateg(Connection con,String name) {
        ResultSet rs;
        float price = 0;

        try{
            PreparedStatement pst=con.prepareStatement("Select categories.price\n" +
                    "from categories\n" +
                    "where categories.name=?;");
            pst.setString(1,name);
            rs= pst.executeQuery();
            while(rs.next()){
                price=rs.getFloat("price");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return price;
    }
    public float getPriceOfChan(Connection con,String name)  {
        float price = 0;
        try{
            PreparedStatement pst= con.prepareStatement("Select chanels.price\n" +
                    "from chanels\n" +
                    "where chanels.name=?;");
            pst.setString(1,name);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
                price=rs.getFloat("price");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return price;
    }


    public Map<String, Float> allCategories(Connection con)  {
        Map<String,Float> prices= new HashMap<>();
        try{
            ResultSet rs;
            PreparedStatement pst=con.prepareStatement("Select * from categories;");
            rs=pst.executeQuery();

            while(rs.next()){
                Float price=rs.getFloat("price");
                String name=rs.getString("name");
                prices.put(name,price);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return prices;
    }

    public void  allCategoriesforShowing(Connection con)  {

        try{
            ResultSet rs;
            PreparedStatement pst=con.prepareStatement("Select * from categories;");
            rs=pst.executeQuery();

            while(rs.next()){
               int id=rs.getInt("id");
                String name=rs.getString("name");

            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }


    public void  insertchanelintopackage(Connection con, int idofchannelwanttoadd,int idofpackageyouwanttoaddto)  {
        int idofpackage = 0;
        int idofchannel = 0;
        try
        {
            con.setAutoCommit(false);
            Statement pst = con.createStatement();
            ResultSet rs= pst.getGeneratedKeys() ;
            while (rs.next()){
                idofchannel =rs.getInt("id");
                if(idofchannelwanttoadd==idofchannel){
                    break;
                }
            }
            Statement pst1 = con.createStatement();
            ResultSet rs1= pst1.getGeneratedKeys();
            while (rs1.next()){
                idofpackage =rs.getInt("id");
                if(idofpackageyouwanttoaddto==idofpackage){
                    break;
                }
            }
             PreparedStatement pst2=con.prepareStatement("Insert into chanel_package(chanel_id,package_id) values(?,?);");
            pst2.setInt(1,idofchannel);
            pst2.setInt(2,idofpackage);
            pst2.executeQuery();
            con .commit();
        }
        catch(Exception e)
        {
           try{
               con.rollback();
           }
           catch (SQLException p){
               System.out.println(p.getMessage());
           }
        }
        finally
        {
            try{
                con.setAutoCommit(true);
            }
            catch (SQLException p){
                System.out.println(p.getMessage());
            }

        }

        }

    public void  insertcategoryintopackage(Connection con,  int idofwantedpackage, int idofwantedCategory)  {
        int idofpackage = 0;
        int idofcategory = 0;
        try
        {
            con.setAutoCommit(false);
            Statement pst = con.createStatement();
            ResultSet rs= pst.getGeneratedKeys();
            while (rs.next()){
                idofcategory =rs.getInt("id");
                if(idofwantedCategory==idofcategory){
                    break;
                }
            }
            Statement pst1 = con.createStatement();
            ResultSet rs1= pst1.getGeneratedKeys();
            while (rs1.next()){
                idofpackage =rs.getInt("id");
                if(idofwantedpackage==idofpackage){
                    break;
                }
            }
            PreparedStatement pst2=con.prepareStatement("Insert into chanel_package(chanel_id,package_id) values(?,?);");
            pst2.setInt(1,idofcategory);
            pst2.setInt(2,idofpackage);
            pst2.executeQuery();
            con .commit();
        }
        catch(Exception e)
        {
            try{
                con.rollback();
            }
            catch (SQLException p){
                System.out.println(p.getMessage());
            }
        }
        finally
        {
            try{
                con.setAutoCommit(true);
            }
            catch (SQLException p){
                System.out.println(p.getMessage());
            }

        }
    }
    public Map<String, String> nameadnpass (Connection con)  {
        Map<String,String> passwords = new HashMap<>();
        try{
            ResultSet rs;
            PreparedStatement pst=con.prepareStatement("Select username,pass from TV_Operator.clients;");
            rs=pst.executeQuery();

            while(rs.next()){
                String password=rs.getString("pass");
                String name=rs.getString("username");
                passwords.put(name,password);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return passwords;
    }



}
