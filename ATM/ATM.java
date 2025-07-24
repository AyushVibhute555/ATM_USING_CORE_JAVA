package ATM;

import java.util.Scanner;
import java.util.*;
import java.text.*;

class Account
{
    DecimalFormat df1=new DecimalFormat("##,###0.00' Rupee'");
    DecimalFormat df2=new DecimalFormat("##,###0.00' Rupee'");
    Scanner input = new Scanner(System.in);


    private int CN;
    private int pn;
    double CB=2000;
    double SB=2000;

    void setCustomerNumber(int cn) //setters
    {
        CN=cn;
    }

    void setPINNumber(int pn)//setters
    {
        this.pn=pn;
    }

    int getCustomerNumber(){
        return CN;
    }

    int getPINNUmber(){
        return pn;
    }

    void getCurrentBalance()
    {
        System.out.println("\nCurrent Account Balance: "+df1.format(CB));
    }

    void getSavingBalance()
    {
        System.out.println("\nSaving Account Balance: "+df2.format(CB));
    }

    void getCurrentWithdrawInput()
    {
        System.out.println("\nCurrent Account Balance:"+df1.format(CB));
        System.out.print("Enter the amount you want to withdraw: ");
        double amount=input.nextDouble();

        if((CB-amount)>=0)
        {
            calcCurrentWithdraw(amount);
            System.out.println("\nTransaction Successful");
            System.out.println("\nCurrent Account Balance:"+df1.format(CB));

        }
        else
        {
            System.out.println("\nInsufficient Balance");
        }
    }

    double calcCurrentWithdraw(double amount)
    {
        CB=CB-amount;
        return CB;
    }

    void getSavingWithdrawInput()
    {
        System.out.println("\nCurrent Saving Balance:"+df2.format(SB));
        System.out.print("Enter the amount you want to withdraw: ");
        double amount=input.nextDouble();

        if((SB-amount)>=0)
        {
            calcCurrentWithdraw(amount);
            System.out.println("\nTransaction Successful");
            System.out.println("\nCurrent Account Balance:"+df2.format(SB));

        }
        else
        {
            System.out.println("\nInsufficient Balance");
        }
    }
    double calcSavingWithdraw(double amount)
    {
        SB=SB-amount;
        return SB;
    }

    void getCurrentDepositInput()
    {
        System.out.println("\nCurrent Balance Amount: "+df1.format(CB));
        System.out.println("Enter Amount to Deposit: ");
        double amount=input.nextDouble();

        if((CB+amount)>=0)
        {
            calCurrentDeposit(amount);
            System.out.println("Transaction Successful");
            System.out.print("\nCurrent Balance Amount "+df1.format(CB));
        }
        else
        {
            System.out.println("\nTransaction Failed..");
        }
    }
    double calCurrentDeposit(double amount)
    {
        CB+=amount;
        return amount;
    }
    void getSavingDepositInput()
    {
        System.out.println("\nCurrent Balance Amount: "+df2.format(SB));
        System.out.println("Enter Amount to Deposit: ");
        double amount=input.nextDouble();

        if((SB+amount)>=0)
        {
            calSavingDeposit(amount);
            System.out.println("Transaction Successful");
            System.out.print("\nCurrent Balance Amount "+df2.format(SB));

        }
        else
        {
            System.out.println("\nTransaction Failed..");
        }
    }
    double calSavingDeposit(double amount)
    {
        SB+=amount;
        return amount;
    }

}

class OptionMenu extends Account {
    Scanner input = new Scanner(System.in);
    HashMap<Integer, Integer> data = new HashMap<>();

    void getLogin() {
        int i = 10;
        do {
            try {
                data.put(1111, 123);
                data.put(1112, 456);
                data.put(1113, 789);
                data.put(1114, 123);

                System.out.println("Hello, Welcome to the ATM");

                System.out.print("\nEnter the customer Number :");
                setCustomerNumber(input.nextInt());

                System.out.print("Enter Your Pin              :");
                setPINNumber(input.nextInt());

                int P = getCustomerNumber();
                int Q = getPINNUmber();

                if (data.containsKey(P) && data.get(P) == Q) {
                    System.out.println("Login Done...");
                    getAccountType();
                } else {
                    System.out.println("login Failed");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter only number.");
                System.out.println("char and symbol are not allowed");
                input.next();
                getLogin();
            }
        } while (i == 10);
    }

    void getAccountType() {
        System.out.print("\nSelect the Account type:");
        System.out.print("\nType 1: Current Account");
        System.out.print("\nType 2: Saving Account");
        System.out.print("\nType 3: Exit");
        System.out.print("\nChoice");

        int ch = input.nextInt();
        switch (ch) {
            case 1:getCurrent();
                break;
            case 2:getSaving();
                break;
            case 3:
                System.out.println("\nThank you for visiting.");
                System.out.println("visit Again");
                break;
            default:
                System.out.println("\n Invalid Choice.");
                System.out.print("\nEnter a valid Choice:");
                getAccountType();
                break;
        }
    }

    void getCurrent() {
        System.out.println("\nCURRENT ACCOUNT");
        System.out.println("\nType 1 : Balance Enquiry");
        System.out.println("Type 2 : Withdraw");
        System.out.println("Type 3 : Deposit");
        System.out.println("Type 4 : Exit");


    int ch = input.nextInt();
        switch(ch)

    {
        case 1: getCurrentBalance();
        getAccountType();
            break;
        case 2:getCurrentWithdrawInput();
            getAccountType();
            break;
        case 3:getCurrentDepositInput();
            getAccountType();
            break;
        case 4:System.out.println("\nThank you for visiting.");
            System.out.println("Visit Again");
        default:
            System.out.println("\n Invalid Choice.");
            System.out.print("\nEnter a valid Choice:");
            getAccountType();
            break;
    }
}
    void getSaving() {
        System.out.println("\nCURRENT ACCOUNT");
        System.out.println("\n Type 1 : Balance Enquiry");
        System.out.println("Type 2 : Withdraw");
        System.out.println("Type 3 : Deposit");
        System.out.println("Type 4 : Exit");


        int ch = input.nextInt();
        switch(ch)

        {
            case 1:getSavingBalance();
                getAccountType();
                break;
            case 2:getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:getSavingDepositInput();
                getAccountType();
                break;
            case 4: System.out.println("\nThank you for visiting.");
                System.out.println("Visit Again");
                break;
            default:
                System.out.println("\n Invalid Choice.");
                System.out.print("\nEnter a valid Choice:");
                getAccountType();
                break;
        }
    }

}
public class ATM extends OptionMenu
{
    public static void main(String[] args)
    {
        OptionMenu obj=new OptionMenu();
        obj.getLogin();
    }

}
