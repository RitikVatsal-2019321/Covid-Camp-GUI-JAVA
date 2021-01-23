//RITIK VATSAL ||  2019321
//Advanced Programming Assignment 1








package com.company;



import javax.swing.*;
import java.util.*;
import java.lang.*;


public class Main {
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int patnum=in.nextInt();
//        ArrayList<Patient> pList=new ArrayList<>();
        Patient[] pList=new Patient[patnum];
        ArrayList<Aspatal> aList=new ArrayList<>();
        int chck=patnum;
        int BADS=0;
        int[] recovtime=new int[patnum];
        for (int i = 0; i <patnum ; i++) {

            String naem=in.next();
            float temp=in.nextFloat();
            int o2=in.nextInt();
            int age=in.nextInt();

            Patient bruh=new Patient(naem,temp,o2,age);
            pList[i]=bruh;


        }
        while (chck>0){
            int swtch=in.nextInt();
            if (swtch==1){
                String Aname=in.next();
                System.out.print("Temperature Criteria - ");
                float toptemp=in.nextFloat();
                System.out.print("\nOxygen Levels - ");
                int leasto2=in.nextInt();
                System.out.print("\nAvailable Beds - ");
                int bed=in.nextInt();
                System.out.println(Aname);
                System.out.println("Temperature should be <= "+toptemp+ "\n" +
                        "Oxygen levels should be >= "+leasto2+"\n" +
                        "Number of Available beds – "+bed+"\nAdmission Status – OPEN");




                    for (int i = 0; i <patnum ; i++) {
                        if (pList[i].o2>=leasto2 && bed>0 && pList[i].age>0){
//                            aspatal.additionslist.add(pList[i]);
                            System.out.print("Enter recovery time for Patient ID_");
                            System.out.println(i+1);
                            recovtime[i]=in.nextInt();
                            pList[i].age=-3;
                            pList[i].hos=Aname;
                            bed=bed-1;
                            chck=chck-1;

                        }
                    }

                    if (bed>0){
                        for (int i = 0; i <patnum ; i++) {
                            if (pList[i].temp<=toptemp && bed>0 && pList[i].age>0){
//                            aspatal.additionslist.add(pList[i]);
                                System.out.print("Enter recovery time for Patient ID_");
                                System.out.println(i+1);
                                recovtime[i]=in.nextInt();
                                pList[i].age=-3;
                                pList[i].hos=Aname;
                                bed=bed-1;
                                chck=chck-1;

                            }
                        }

                    }



                Aspatal aspatal=new Aspatal(Aname, toptemp, leasto2,bed);
                aList.add(aspatal);
            }

            if (swtch==2){
                System.out.println("Account IDs removed of admitted patients are");
                for (int i = 0; i < patnum ; i++) {
                    if (pList[i].age==-3){
                        System.out.println(i+1);
                        pList[i].age=-6;
                    }
                }
            }

            if (swtch==3){
                System.out.println("Following Hospital(s) Wiped from the Database - ");
                for (int i = 0; i <aList.size() ; i++) {

                    if (aList.get(i).bed==0){
                        aList.get(i).bed=-1;

                        System.out.println(aList.get(i).Aname);

                    }

                }
            }

            if (swtch==4){
                int cnt=0;
                for (int i = 0; i < patnum; i++) {

                    if (pList[i].age>0){
                        cnt=cnt+1;
                    }

                }
                System.out.print("Number of Patients in the camp - ");
                System.out.println(cnt);
            }

            if (swtch==5){
                System.out.println("Number of Open Hospitals - ");
                int cont=0;
                for (int i = 0; i < aList.size() ; i++) {
                    if (aList.get(i).bed>0){
                        cont=cont+1;
                    }

                }
                System.out.println(cont);
            }

            if (swtch==6){
                String fyi=in.next();
                for (int i = 0; i <aList.size() ; i++) {
                    if (aList.get(i).Aname.equals(fyi)){
                        System.out.println(aList.get(i).Aname);
                        System.out.println("Temperature should be <= "+aList.get(i).toptemp+ "\n" +
                                "Oxygen levels should be >= "+aList.get(i).leasto2+"\n" +
                                "Number of Available beds – ");


                        if (aList.get(i).bed>0){
                            System.out.println(aList.get(i).bed);
                            System.out.println("Admission Status - OPEN");
                        }
                        else{
                            System.out.println(0);
                            System.out.println("Admission Status - CLOSED" );
                        }
                    }

                }
            }

            if (swtch==7){
                int patno=in.nextInt();
                printer(pList, patno-1);
            }

            if (swtch==8){

                for (int i = 0; i < patnum ; i++) {

                    if (pList[i].age!=-6){
                    System.out.print(i+1+" ");
                    System.out.println(pList[i].naem);

                }
                }


            }

            if (swtch==9){
                String fygg=in.next();
                for (int i = 0; i < patnum ; i++) {
//                    System.out.println(i);
//                    System.out.println(pList.length);
                    if (pList[i].age<0){
                    if (pList[i].hos.equals(fygg)){

                        System.out.print(pList[i].naem + "   ");
                        System.out.print(recovtime[i]+" Days     ");
                        if (pList[i].age==-6){
                            System.out.println("**Account Deleted From Database!**");
                        }
                        System.out.println();

                    }
                    }


                }
            }
        }




    }

     public static void  printer(Patient[] pList, int num){
        System.out.println(pList[num].naem);
        System.out.println("Patient ID - " + num);
        System.out.println("Temperature is "+pList[num].temp);
        System.out.println("Oxygen Level is " + pList[num].o2);
        if (pList[num].age>0){
            System.out.println("Unadmitted");
        }
        else{
            System.out.println("Admitted");
            System.out.println("Hospital Name - "+ pList[num].hos);
        }
    }
}

class Patient{
    String naem;
    float temp;
    int o2;
    int age;
    String hos;

    public Patient(String naem, float temp, int o2, int age){
        this.naem=naem;
        this.temp=temp;
        this.o2=o2;
        this.age=age;
    }
    public Patient(){
        this.age=-3;
    }


}

class Aspatal{
    String Aname;
    float toptemp;
    int leasto2;
    int bed;
    ArrayList<Patient> additionslist;

    public Aspatal(String Aname, float toptemp, int leasto2, int bed){
        this.Aname=Aname;
        this.toptemp=toptemp;
        this.leasto2=leasto2;
        this.bed=bed;
        this.additionslist=new ArrayList<>();
    }


}
