import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static javafx.application.Platform.exit;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {

        Scanner sc= new Scanner(System.in);
        System.out.println(" Start Menu");
        Menu.logInOrSignUp();
        String command;
        System.out.println("Enter command");
        System.out.println("Enter 1 for Profile update \n 2 to delete your account\n 3 to for other changes\n 4 to change price of all channels \n 5 to exit ");
        command= sc.nextLine();
        while (true) {
            if (command.equals("1")) {
                Menu.update();
            } else if (command.equals("2")) {
                Menu.delete();
            } else if (command.equals("3")) {
                System.out.println("Choose what you wanna manipulate");
                String enternalCommand;
                enternalCommand = sc.nextLine();
                if (enternalCommand.equals("Category")) {
                    System.out.println("Enter Insert to add new Category\n Enter Update to make changes over existing category\n Enter Delete to remove category from list");
                    String moreEnternalCommand = sc.nextLine();
                    if (moreEnternalCommand.equals("Insert")) {
                        Menu.newCategory();
                    } else if (moreEnternalCommand.equals("Update")) {
                        Menu.updateCategory();
                    } else if (moreEnternalCommand.equals("Delete")) {
                        Menu.deleteCategory();
                    }
                } else if (enternalCommand.equals("Deliver")) {
                    System.out.println("Enter Insert to add new Deliver\n Enter Update to make changes over existing Deliver\n Enter Delete to remove deliver from list");
                    String moreEnternalCommand = sc.nextLine();
                    if (moreEnternalCommand.equals("Insert")) {
                        Menu.newDeliver();

                    } else if (moreEnternalCommand.equals("Update")) {
                        Menu.updateDeliver();

                    } else if (moreEnternalCommand.equals("Delete")) {
                        Menu.deleteDeliver();

                    }
                } else if (enternalCommand.equals("Contracts")) {
                    System.out.println("Enter Insert to add new contract\n Enter Update to make changes over existing contract\n Enter Delete to remove contract from list");
                    String moreEnternalCommand = sc.nextLine();
                    if (moreEnternalCommand.equals("Insert")) {
                        Menu.newContract();
                    } else if (moreEnternalCommand.equals("Update")) {
                        Menu.updateLenghtContract();

                    } else if (moreEnternalCommand.equals("Delete")) {
                        Menu.deleteContract();
                    }
                } else if (enternalCommand.equals("Channels")) {
                    System.out.println("Enter Insert to add new channel\n Enter Update to make changes over existing channels\n Enter Delete to remove channel from list");
                    String moreEnternalCommand = sc.nextLine();
                    if (moreEnternalCommand.equals("Insert")) {
                        Menu.newChannel();
                    } else if (moreEnternalCommand.equals("Update")) {
                        Menu.updateChannel();
                    } else if (moreEnternalCommand.equals("Delete")) {
                        Menu.deleteChannel();
                    }
                }
            } else if (command.equals("4")) {
                Menu.updateprice();
            } else if (command.equals("5")) {
                exit();
            }
            command= sc.nextLine();
        }
    }
}
