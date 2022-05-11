import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.lang.System;

public class Menu {

    public static void logInOrSignUp() throws SQLException, IOException {
        Scanner sc= new Scanner(System.in);
        String password;
        String username;
        String email;
        String egn;

        UsernameValidator usv=new UsernameValidator() ;
       do{

           System.out.println("Enter correct username");
           username=sc.nextLine();

       }while(!(usv.validateUserName(username)));
        SQLConnector sql = new SQLConnector();
        Map<String,String> passwords = sql.nameadnpass(ConnectionFactory.getCon());
            String flag=" ";
            String  usercheck= sql.lookforuser(ConnectionFactory.getCon(),username,flag);
            if(!usercheck.equals(" ")){
                do{
                    System.out.println("Enter password");
                    password= sc.nextLine();
                }while(!password.equals(passwords.get(usercheck)));

                System.out.println("Enter successfully");


            }
            else{
                sql.addPackages(ConnectionFactory.getCon());
                System.out.println("Enter password");
                password=sc.nextLine();
                System.out.println("Enter email");
                email=sc.nextLine();
                System.out.println("Enter egn");
                egn= sc.nextLine();
                 int package_id=sql.getkey(ConnectionFactory.getCon());

                sql.addClients(ConnectionFactory.getCon(),username,password,email,egn,package_id);
                Menu.managePlan();
            }
    }
    public static void delete() throws SQLException, IOException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter name of client you want to delete");
        String name=sc.nextLine();
        System.out.println("Enter the id of your package");
        int id=sc.nextInt();
        SQLConnector sql = new SQLConnector();
        sql.deleteClients(ConnectionFactory.getCon(),name);
        sql.deletePackages(ConnectionFactory.getCon(),id);

    }

    public static void update() throws SQLException, IOException {
        SQLConnector sql=new SQLConnector();
        Scanner sc=new Scanner(System.in);
        String command=sc.nextLine();

        if(command.equals("1")){
            System.out.println("Enter egn");
            String egn= sc.nextLine();
            sql.updateClientname(ConnectionFactory.getCon(),egn);
        }
      else  if(command.equals("2")){
            System.out.println("Enter egn");
            String egn = sc.nextLine();
            sql.updateClientpass(ConnectionFactory.getCon(), egn);
        }
      else if(command.equals("3")){
            System.out.println("Enter egn");
            String egn = sc.nextLine();
            sql.updateClientmail(ConnectionFactory.getCon(), egn);
        }
    }


    public static void newCategory() throws SQLException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name= sc.nextLine();
        System.out.println("Enter price");
        float price= sc.nextFloat();
        SQLConnector sql = new SQLConnector();
        sql.addCategory(ConnectionFactory.getCon(),name,price);
    }

    public static void deleteCategory() throws SQLException,IOException{
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter name of category you want to delete");
        String name=sc.nextLine();
        SQLConnector sql = new SQLConnector();
        sql.deleteCategory(ConnectionFactory.getCon(),name);
    }

    public static void updateCategory() throws SQLException, IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new price");
        float price= sc.nextFloat();
        SQLConnector sql = new SQLConnector();
        sql.updateCategoryprice(ConnectionFactory.getCon(),price);
    }
    public static void newDeliver() throws SQLException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name= sc.nextLine();
        SQLConnector sql = new SQLConnector();
        sql.addDelivers(ConnectionFactory.getCon(),name);
    }

    public static void deleteDeliver() throws SQLException,IOException{
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter name of deliver you want to delete");
        String name=sc.nextLine();
        SQLConnector sql = new SQLConnector();
        sql.deleteDelivers(ConnectionFactory.getCon(),name);
    }

    public static void updateDeliver() throws SQLException, IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name= sc.nextLine();
        SQLConnector sql = new SQLConnector();
        sql.updateDeliver(ConnectionFactory.getCon(),name);
    }

    public static void newContract() throws SQLException,IOException{
        Scanner sc = new Scanner(System.in);
        SQLConnector sql = new SQLConnector();
        System.out.println("Enter number of contract");
        String number=sc.nextLine();
        System.out.println("Enter length ot contract");
        int lengthOfContract=sc.nextInt();
         float value=sc.nextFloat();
        System.out.println("Enter value of contract");
        System.out.println("Enter id of deliver");
         int  deliver_id=sc.nextInt();
         sql.addContracts(ConnectionFactory.getCon(),value,number,lengthOfContract,deliver_id);
    }

    public static void updateLenghtContract() throws SQLException, IOException {
        Scanner sc=new Scanner(System.in);
        SQLConnector sql = new SQLConnector();
        System.out.println("Enter the number of contract you want to update");
        String number=sc.nextLine();
        System.out.println("Enter new lenght of contract");
        int lengthOfContract=sc.nextInt();
        sql.updateContractlenght(ConnectionFactory.getCon(),lengthOfContract,number);
    }

    public static void deleteContract() throws SQLException,IOException{
       Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of contract you want to delete");
        String number=sc.nextLine();
        SQLConnector sql = new SQLConnector();
        sql.deleteContracts(ConnectionFactory.getCon(),number);
    }
    public static void newChannel() throws SQLException, IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter price");
        float price=sc.nextFloat();
        System.out.println("Enter id of contract channel belongs to");
        int contract_id=sc.nextInt();
        System.out.println("Enter id of channel category");
        int category_id=sc.nextInt();
        SQLConnector sql = new SQLConnector();
        sql.addChannel(ConnectionFactory.getCon(),name,price,contract_id,category_id);
    }
    public static void updateChannel() throws SQLException, IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter command");
        System.out.println("name to update name of channel\n price to change price of channe");
        String command= sc.nextLine();
        SQLConnector sql = new SQLConnector();
        if(command.equals("name")){
            System.out.println("Enter name");
            String name=sc.nextLine();
            sql.updateChannelsname(ConnectionFactory.getCon(),name);
        }
        else if(command.equals("price")){
            System.out.println("Enter new price");
            float price=sc.nextFloat();
            sql.updateChannelsprice(ConnectionFactory.getCon(),price);
        }
    }

    public static void deleteChannel() throws SQLException, IOException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter name of channel you want to delete");
        String name=sc.nextLine();
        SQLConnector sql = new SQLConnector();
        sql.deleteChannels(ConnectionFactory.getCon(),name);
    }

    public static void managePlan() throws SQLException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of package you wanna change");
        int idofpackage = sc.nextInt();
        SQLConnector sql = new SQLConnector();
        float price=0;
        System.out.println("Choose what you wanna add");
        System.out.println("For channel enter 1; for category enter 2; to end enter exit");
        String command;
        command=sc.nextLine();

        while(true){

            if(command.equals("1")){
                sql.allChannels(ConnectionFactory.getCon());
                System.out.println("Enter number of channel");
                int idofchanel=sc.nextInt();
                sql.allChannels(ConnectionFactory.getCon());
                String channel=sql.getChannelById(ConnectionFactory.getCon(),idofchanel);
                String temp = sql.getChannel(ConnectionFactory.getCon(), channel);
                if(temp.equals(" ")){
                    Menu.managePlan();
                }
                else{
                    if (sql.incatornot(ConnectionFactory.getCon(),temp,idofpackage)==0){
                        sql.insertchanelintopackage(ConnectionFactory.getCon(),idofchanel,idofpackage);
                        price+= sql.getPriceOfChan(ConnectionFactory.getCon(),temp);
                        sql.updatepackageprice(ConnectionFactory.getCon(),price,idofchanel);
                    }
                    else{
                        Menu.managePlan();
                    }
                }
            }
            else if(command.equals("2")){
                sql.allCategoriesforShowing(ConnectionFactory.getCon());
                System.out.println("Enter number of category");
                int idofcategory=sc.nextInt();
                String category = sql.getCategoryById(ConnectionFactory.getCon(),idofcategory);
                String temp=sql.getCategory(ConnectionFactory.getCon(),category);
                if(sql.catinpack(ConnectionFactory.getCon(),temp,idofpackage)!=0 || temp.equals(" ")){
                    Menu.managePlan();
                }
                else{
                    sql.insertcategoryintopackage(ConnectionFactory.getCon(),idofpackage,idofcategory);
                    price+= sql.getPriceOfCateg(ConnectionFactory.getCon(),temp);
                    sql.updatepackageprice(ConnectionFactory.getCon(),price,idofpackage);
                }
            }
            else if(command.equals("exit")){
                break;
            }
            command=sc.nextLine();
        }
    }


    public static void updateprice() throws SQLException, IOException {
        float percentage;
        Scanner sc=new Scanner(System.in);
        SQLConnector sql=new SQLConnector();
        System.out.println("Enter percentage for price changing;use - for in case of decreasing");
        percentage= sc.nextFloat();
        Map<String,Float> prices;
        prices=sql.allCategories(ConnectionFactory.getCon());
        int ps;
        ps=prices.size();
        String[] keys =  prices.keySet().toArray(new String[ps]);
        Float[] values;
        values=prices.values().toArray(new Float[ps]);
        Map<String,Float> updatedPrices= new HashMap<>();
        for(int i=0;i<prices.size();i++){
            String n =keys[i];
            float p=values[i]+values[i]*(percentage/100);
            updatedPrices.put(n,p);
            sql.updatepackageprice(ConnectionFactory.getCon(),p,i+1);
        }

    }
}

