package com.example.project_ssc;

public class IF {

    public static String pc="0000000000000000000000000000000";
    public static String inst="0000000000000000000000000000000";

    public static void ProgCount() {
        int pcDec = convertToDecimal(pc);
        pcDec += 1;
        pc = convertToBinary(pcDec);
    }
    public static void IF(String address)
    {
        int addressDec = convertToDecimal(address);
        inst = MemoryInstruction.instMemory[addressDec];
        String op = inst.substring(0,10);
        if(op.equals("0000000001")) {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String immediate = inst.substring(22,32);
            int rsDec = convertToDecimal(rs);
            int rtDec = convertToDecimal(rt);
            int immediateDec = convertToDecimal(immediate);
            System.out.println("ADD " + "rS" + rsDec + " rT" + rtDec + " " +immediateDec + " in Fetch stage:");
        }
        if(op.equals("0000000010")) {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String immediate = inst.substring(22,32);
            int rsDec = convertToDecimal(rs);
            int rtDec = convertToDecimal(rt);
            int immediateDec = convertToDecimal(immediate);

            System.out.println("ADDi " + "rS" + rsDec + " rT" + rtDec + " " + immediateDec + " in Fetch stage:");
        }
        if(op.equals("0000000011")) {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String immediate = inst.substring(22,32);
            int rsDec = convertToDecimal(rs);
            int rtDec = convertToDecimal(rt);
            int immediateDec = convertToDecimal(immediate);

            System.out.println("SUB " + "rS" + rsDec + " rT" + rtDec + " "  + " in Fetch stage:");
        }
        if(op.equals("0000000100")) {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String immediate = inst.substring(22,32);
            int rsDec = convertToDecimal(rs);
            int rtDec = convertToDecimal(rt);
            int immediateDec = convertToDecimal(immediate);

            System.out.println("MULT " + "rS" + rsDec + " rT" + rtDec + " " +  immediateDec + " in Fetch stage:");
        }
        if(op.equals("0000000101")) {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String immediate = inst.substring(22,32);
            int rsDec = convertToDecimal(rs);
            int rtDec = convertToDecimal(rt);
            int immediateDec = convertToDecimal(immediate);

            System.out.println("AND " + "rS" + rsDec + " rT" + rtDec + " "  + " in Fetch stage:");
        }
        if(op.equals("0000000110")) {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String immediate = inst.substring(22,32);
            int rsDec = convertToDecimal(rs);
            int rtDec = convertToDecimal(rt);
            int immediateDec = convertToDecimal(immediate);

            System.out.println("ORi " + "rS" + rsDec + " rT" + rtDec  + " " + immediateDec + " in Fetch stage:");
        }
        if(op.equals("0000000111")) {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String immediate = inst.substring(22,32);
            int rsDec = convertToDecimal(rs);
            int rtDec = convertToDecimal(rt);
            int immediateDec = convertToDecimal(immediate);

            System.out.println("SLL " + "rS" + rsDec + " rT" + rtDec  + " " + immediateDec + " in Fetch stage:");
        }
        if(op.equals("0000001000")) {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String immediate = inst.substring(22,32);
            int rsDec = convertToDecimal(rs);
            int rtDec = convertToDecimal(rt);
            int immediateDec = convertToDecimal(immediate);

            System.out.println("SRL " + "rS" + rsDec + " rT" + rtDec + " " + immediateDec + " in Fetch stage:");
        }
        if(op.equals("0000001001")) {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String immediate = inst.substring(22,32);
            int rsDec = convertToDecimal(rs);
            int rtDec = convertToDecimal(rt);
            int immediateDec = convertToDecimal(immediate);

            System.out.println("LW  " + "rS" + rsDec + " rT" + rtDec + " " + immediateDec + " in Fetch stage:");
        }
        if(op.equals("0000001010")) {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String immediate = inst.substring(22,32);
            int rsDec = convertToDecimal(rs);
            int rtDec = convertToDecimal(rt);
            int immediateDec = convertToDecimal(immediate);

            System.out.println("SW  " + "rS" + rsDec + " rT" + rtDec + " " + immediateDec + " in Fetch stage:");
        }
        if(op.equals("0000001011")) {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String immediate = inst.substring(22,32);
            int rsDec = convertToDecimal(rs);
            int rtDec = convertToDecimal(rt);
            int immediateDec = convertToDecimal(immediate);
            System.out.println("BNE " + "rS" + rsDec + " rT" + rtDec + " " + immediateDec + " in Fetch stage:");
        }
//        if(op.equals("0000001100")) {
//            String rs = inst.substring(10,16);
//            String rt = inst.substring(16,22);
//            String immediate = inst.substring(22,32);
//            int rsDec = convertToDecimal(rs);
//            int rtDec = convertToDecimal(rt);
//            int immediateDec = convertToDecimal(immediate);
//            System.out.println("BGT " + "rS" + rsDec + " rT" + rtDec + " " + immediateDec + " in Fetch stage:");
//        }
        if(op.equals("0000001101")) {
            String rs = inst.substring(10,16);
            System.out.println(rs);
            String rt = inst.substring(16,22);
            System.out.println(rt);
            String rd = inst.substring(22,32);
            System.out.println(rd);
            int rxDec = convertToDecimal(rs);
            int ryDec = convertToDecimal(rt);
            int rzDec = convertToDecimal(rd);
            System.out.println("SLT " + "rS" + rxDec + " rT" + ryDec + " rD" + rzDec + " in Fetch stage:");


        }
        if (op.equals("1000000000"))
        {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String rd = inst.substring(22,32);
            int rxDec = convertToDecimal(rs);
            int ryDec = convertToDecimal(rt);
            int rzDec = convertToDecimal(rd);
            System.out.println("OR " + "rS" + rxDec + " rT" + ryDec + " rD" + rzDec + " in Fetch stage:");
        }
        if (op.equals("1000000001"))
        {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String rd = inst.substring(22,32);
            int rxDec = convertToDecimal(rs);
            int ryDec = convertToDecimal(rt);
            int rzDec = convertToDecimal(rd);
            System.out.println("XOR " + "rS" + rxDec + " rT" + ryDec + " rD" + rzDec + " in Fetch stage:");
        }
        if (op.equals("1000000010"))
        {
            String rs = inst.substring(10,16);
            String rt = inst.substring(16,22);
            String rd = inst.substring(22,32);
            int rxDec = convertToDecimal(rs);
            int ryDec = convertToDecimal(rt);
            int rzDec = convertToDecimal(rd);
            System.out.println("ANDI " + "rS" + rxDec + " rT" + ryDec + " rD" + rzDec + " in Fetch stage:");
        }
        if(op.equals("0000001110")) {
            String immediate = inst.substring(10,32);
            int immediateDec = convertToDecimal(immediate);
            System.out.println("J " + immediateDec + " in Fetch stage:");
        }
        ProgCount();
        System.out.println("Next PC = " + pc);
        System.out.println("Instruction:" + inst);
        System.out.println("\n\n");
        MainController.IFID[MainController.IFIDindex] = inst;
        MainController.IFIDindex += 1;
        MainController.IFID[MainController.IFIDindex] = pc;
        MainController.IFIDindex += 1;

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

