package com.example.project_ssc;

import java.util.ArrayList;

public class MainController {

    // rewgistrii intermediari
    public static String[] IFID = new String[500000];
    public static String[] IDEX = new String[500000];
    public static String[] EXMEM = new String[500000];
    public static String[] MEMWB = new String[500000];

    // index
    public static int IFIDindex = 0;
    public static int IDEXindex = 0;
    public static int EXMEMindex = 0;
    public static int MEMWBindex = 0;
    public static int cycle = 0;
    public static Integer pcInteger=0;
    public static ArrayList<Instruction> running = new ArrayList<Instruction>();

    public static void runSimulation( )
    {

        while(true) {
            System.out.println("\n-------------\n");
            cycle += 1;
            System.out.println("Cycle : " + cycle);
            System.out.println("\n");
            pcInteger=convertToDecimal(IF.pc);
            if((convertToDecimal(IF.pc)<=MemoryInstruction.instMemory.length)&&MemoryInstruction.instMemory[convertToDecimal(IF.pc)]!= null) {
                // creez o noua instructiune care va avea codificarea din instruction memory
                running.add(new Instruction(MemoryInstruction.instMemory[convertToDecimal(IF.pc)]));
            }
            for (int i = 0; i < running.size(); i++) {
                if (!running.isEmpty() && i >= 0) {
//                    System.out.println("IF.pc" +IF.pc);
                    switch (running.get(i).stage) {
                        case 1:
                            IF.IF(IF.pc);
                            running.get(i).stage += 1;
                            break;
                        case 2:
                            ID.ID();
                            running.get(i).stage += 1;
                            break;
                        case 3:
                            EX.ex();
                            running.get(i).stage += 1;
                            break;
                        case 4:
                            Mem.mem();
                            running.get(i).stage += 1;
                            break;
                        case 5:
                            WB.writeBack();
                            running.get(i).stage += 1;
                            break;
                        case 6:
                            running.remove(i);
                            i--;
                            break;
                    }
                }
            }

            if (running.isEmpty()) {
                System.out.println("End");
                break;
            }

        }
    }




    public static int convertToDecimal(String s){
        int result=0;
        int c=0;
        for(int i=s.length()-1;i>-1;i--) {
            String k = "";
            char h = s.charAt(i);
            k+=h;
            result += (Math.pow(2,c)*Integer.parseInt(k));
            c++;
        }
        return result;
    }

    public static String convertToBinary(int n){
        String out = "";
        String zeros = "";
        String z = Integer.toBinaryString(n);
        int rem = 32 - z.length();
        for(int i=0;i<rem;i++) {
            zeros += "0";
        }
        out = zeros + z;
        return out;
    }
}
