import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        System.out.println("Enter the number of disks: ");
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println("The moves are :");
        moveDisks(n,'A','B','C');
    }

    private static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
        if(n==1){
            System.out.println("move disk "+n+"from "+fromTower+"to "+toTower);
        }
        else{
            moveDisks(n-1, fromTower, auxTower, toTower);
            System.out.println("move disk "+n+" from "+fromTower+" to "+toTower);
            moveDisks(n-1, auxTower,  toTower,fromTower);
        }

    }

}
