package com.example.project_ssc;

public class ID {

    public static String op = "";
    public static int rs = 0;
    public static int rt = 0;
    public static int rd = 0;
    public static String immediate = "";
    public static String signExtendOut = "";
    public static String readData1="";
    public static String readData2="";
    public static String RegDst="0";
    public static String RegWrite="0";
    public static String PCSrc="0";
    public static String MemRead="0";
    public static String MemWrite="0";
    public static String MemToReg="0";
    public static int IFIDindex = 0;
    public static void SignExtendItype(String bits) {
        String extend = "";
        char c = bits.charAt(0);
        for(int i=0;i<22;i++) {
            extend += c;
        }
        signExtendOut = extend + bits;
//		System.out.println("sign extended:" + signExtendOut);
    }
    public static void ID() {

        String inst = MainController.IFID[IFIDindex];
        IFIDindex += 1;
        String pc = MainController.IFID[IFIDindex];
       // System.out.println("pc este " +pc);
        IFIDindex +=1;
        op = inst.substring(0,10);
        if(op.equals("0000001001")) {
            //D format lw                      $t  MEM[$s + offset]; PC  PC + 4;
            String rs2 = inst.substring(10,16);
            String rt2= inst.substring(16,22);
            rs = convertToDecimal(rs2);
            rt = convertToDecimal(rt2);
            rd = 0;
            readData1=RegFile.registers[rs];
            readData2=RegFile.registers[rt];
            immediate = inst.substring(22,32);
            System.out.println("LW  " + "rS" + rs + " rT " +rt + "imm: " + convertToDecimal(immediate) + " in Decode stage:");
            System.out.println("Read Data1 : " + readData1);
            System.out.println("Read Data2 : " + readData2);
            System.out.println("Sign Extend : " + signExtendOut);
            int pcDec = convertToDecimal(pc);
            pcDec += 1;
            System.out.println("Next PC : " + convertToBinary(pcDec) );
//            System.out.println("rd : " + convertToBinary(rd));
            MainUnit.ContUnit(op);
            System.out.println("\n\n");



        }
        if(op.equals("0000001010")) {
            //D format sw      MEM[$s + offset]  $t; PC  PC + 4;
            String rs2 = inst.substring(10,16);
            String rt2= inst.substring(16,22);
            rs = convertToDecimal(rs2);
            rt = convertToDecimal(rt2);
            rd = 0;
            readData1=RegFile.registers[rs];
            readData2=RegFile.registers[rt];
            immediate = inst.substring(22,32); // offset in cazul lw si sw
            System.out.println("SW  " + "rS" + rs + "rT " +rt + convertToDecimal(immediate) + " in Decode stage:");
            System.out.println("Read Data1 : " + readData1);
            System.out.println("Read Data2 : " + readData2);
            System.out.println("Sign Extend : " + signExtendOut);
            int pcDec = convertToDecimal(pc);
            pcDec += 1;
            System.out.println("Next PC : " + convertToBinary(pcDec) );

            MainUnit.ContUnit(op);
            System.out.println("\n\n");


        }
        if(op.equals("0000000001")||op.equals("0000000010")||op.equals("0000000011")||op.equals("0000000100")||op.equals("0000000101")||op.equals("0000000110")||op.equals("0000000111")||op.equals("0000001000")||op.equals("0000001011") || op.equals("0000001100") || op.equals("0000000110") || op.equals("1000000010")) {
            //R format opcode rs rt rd
            String rs2 = inst.substring(10,16);
            String rt2 = inst.substring(16,22);
            rs = convertToDecimal(rs2);
            rt = convertToDecimal(rt2);
            rd = 0;
            readData1=RegFile.registers[rs]; // luam valorile din registrii corespunzatori valorilor rs si rt
            readData2=RegFile.registers[rt];
            immediate = inst.substring(22,32);
            SignExtendItype(immediate); // immediatul pentru instructiunile de tip I sau J si rd , registrul destinatie pt cele de tip R
            if(op.equals("0000000001")) {
                System.out.println("ADD " + "rS" + rs + " rT" + rt + " " + " in Decode stage:");
                System.out.println("Read Data1 : " + readData1);
                System.out.println("Read Data2 : " + readData2);
                System.out.println("Next PC : " + pc );
                System.out.println("rs : " + rs);
                System.out.println("rt : " + rt);
                MainUnit.ContUnit(op);
                System.out.println("\n\n");

            }
            if(op.equals("0000000010")) {
                System.out.println("ADDi " + "rS" + rs + " rT" + rt + " " + convertToDecimal(immediate) + " in Decode stage:");
                System.out.println("Read Data1 : " + readData1);
                System.out.println("Read Data2 : " + readData2);
                System.out.println("Sign Extend : " + signExtendOut);
                System.out.println("Next PC : " + pc );
                System.out.println("rs : " + rs);
                System.out.println("rt : " + rt);
                System.out.println("ïmm: "+ immediate);
                MainUnit.ContUnit(op);
                System.out.println("\n\n");

            }
            if(op.equals("0000000011")) {
                System.out.println("SUB " + "rS" + rs + " rT" + rt + " " + " in Decode stage:");
                System.out.println("Read Data1 : " + readData1);
                System.out.println("Read Data2 : " + readData2);
                System.out.println("Next PC : " + pc );
                System.out.println("rs : " + rs);
                System.out.println("rt : " + rt);
                MainUnit.ContUnit(op);
                System.out.println("\n\n");

            }
            if(op.equals("0000000100")) {
                System.out.println("MULT " + "rS" + rs + " rT" + rt + " " + convertToDecimal(immediate) + " in Decode stage:");
                System.out.println("Read Data1 : " + readData1);
                System.out.println("Read Data2 : " + readData2);
                System.out.println("Sign Extend : " + signExtendOut);
                System.out.println("Next PC : " + pc );
                System.out.println("rs : " + rs);
                System.out.println("rt : " + rt);
                MainUnit.ContUnit(op);
                System.out.println("\n\n");

            }
            if(op.equals("0000000101")) {
                System.out.println("AND " + "rS" + rs + " rT" + rt + " "  + " in Decode stage:");
                System.out.println("Read Data1 : " + readData1);
                System.out.println("Read Data2 : " + readData2);
                System.out.println("Next PC : " + pc );
                System.out.println("rs : " + rs);
                System.out.println("rt : " + rt);
                MainUnit.ContUnit(op);
                System.out.println("\n\n");

            }
            if(op.equals("0000000110")) {
                System.out.println("ORi " + "rS" + rs + " rT" + rt + " " + convertToDecimal(immediate) + " in Decode stage:");
                System.out.println("Read Data1 : " + readData1);
                System.out.println("Read Data2 : " + readData2);
                System.out.println("Sign Extend : " + signExtendOut);
                System.out.println("Next PC : " + pc );
                System.out.println("rs : " + rs);
                System.out.println("rt : " + rt);
                System.out.println("imm: " +immediate);
                MainUnit.ContUnit(op);
                System.out.println("\n\n");

            }
            if(op.equals("1000000010")) {
                System.out.println("ANDI " + "rS" + rs + " rT" + rt + " " + convertToDecimal(immediate) + " in Decode stage:");
                System.out.println("Read Data1 : " + readData1);
                System.out.println("Read Data2 : " + readData2);
                System.out.println("Sign Extend : " + signExtendOut);
                System.out.println("Next PC : " + pc );
                System.out.println("rs : " + rs);
                System.out.println("rt : " + rt);
                System.out.println("imm: " +immediate);
                MainUnit.ContUnit(op);
                System.out.println("\n\n");

            }

            if(op.equals("0000000111")) {
                System.out.println("in registrul 0 " +RegFile.registers[0]);
                System.out.println("SLL " + "rS" + rs + " rT" + rt + " " + convertToDecimal(immediate) + " in Decode stage:");
                System.out.println("Read Data1 : " + readData1);
                System.out.println("Read Data2 : " + readData2);
                System.out.println("Sign Extend : " + signExtendOut);
                System.out.println("Next PC : " + pc );
                System.out.println("rs : " + rs);
                System.out.println("rt : " + rt);
                System.out.println("shifted with : " +immediate);
                MainUnit.ContUnit(op);
                System.out.println("\n\n");

            }
            if(op.equals("0000001000")) {
                System.out.println("SRL " + "rS" + rs + " rT" + rt + " " + convertToDecimal(immediate) + " in Decode stage:");
                System.out.println("Read Data1 : " + readData1);
                System.out.println("Read Data2 : " + readData2);
                System.out.println("Sign Extend : " + signExtendOut);
                System.out.println("Next PC : " + pc );
                System.out.println("rs : " + rs);
                System.out.println("rt : " + rt);
                System.out.println("shifted with : " +immediate);
                MainUnit.ContUnit(op);
                System.out.println("\n\n");

            }
            if(op.equals("0000001011")) {
                if(!(RegFile.registers[rs].equals(RegFile.registers[rt]))) {
                    pc = sum(pc,signExtendOut);
                    System.out.println("BNE " + "rS" + rs + " rT" + rt + " " + convertToDecimal(immediate) + " in Decode stage:");
                    System.out.println("Read Data1 : " + readData1);
                    System.out.println("Read Data2 : " + readData2);
                    System.out.println("Sign Extend : " + signExtendOut);
                    System.out.println("Next PC : " + pc);
                    System.out.println("rs : " + rs);
                    System.out.println("rt : " + rt);
                    System.out.println("offset: " + immediate);
                    MainUnit.ContUnit(op);
                    System.out.println("\n\n");

                }
                else {
                    System.out.println("BNE " + "rS" + rs + " rT" + rt + " " + convertToDecimal(immediate) + " in Decode stage:");
                    System.out.println("Read Data1 : " + readData1);
                    System.out.println("Read Data2 : " + readData2);
                    System.out.println("Sign Extend : " + signExtendOut);
                    System.out.println("Next PC : " + pc );
                    System.out.println("rs : " + rs);
                    System.out.println("rt : " + rt);
                    System.out.println("offset: " + immediate);
                    MainUnit.ContUnit(op);
                    System.out.println("\n\n");

                }

            }
            if(op.equals("0000001100")) {
                int rsdec = convertToDecimal(RegFile.registers[rs]);
                int rtdec = convertToDecimal(RegFile.registers[rt]);
                if(rsdec > rtdec) {
                    pc = sum(pc,signExtendOut);
                    System.out.println("BGT " + "rS" + rs + " rT" + rt + " " + convertToDecimal(immediate) + " in Decode stage:");
                    System.out.println("Read Data1 : " + readData1);
                    System.out.println("Read Data2 : " + readData2);
                    System.out.println("Sign Extend : " + signExtendOut);
                    System.out.println("Next PC : " + pc);
                    System.out.println("rx : " + rs);
                    System.out.println("ry : " + rt);
                    System.out.println("Offset: " + immediate);
                    MainUnit.ContUnit(op);
                    System.out.println("\n\n");

                }
                else {
                    System.out.println("BGT " + "rS" + rs + " rT" + rt + " " + convertToDecimal(immediate) + " in Decode stage:");
                    System.out.println("Read Data1 : " + readData1);
                    System.out.println("Read Data2 : " + readData2);
                    System.out.println("Sign Extend : " + signExtendOut);
                    System.out.println("Next PC : " + pc);
                    System.out.println("rx : " + rs);
                    System.out.println("ry : " + rt);
                    System.out.println("Offset: " + immediate);
                    MainUnit.ContUnit(op);
                    System.out.println("\n\n");

                }
            }
        }

        if(op.equals("0000001101")) {
            // C format


            String rs2 = inst.substring(10,16);
            String rt2 = inst.substring(16,22);
            String rd2 = inst.substring(22,32);
            rs = convertToDecimal(rs2);
            rt = convertToDecimal(rt2);
            readData1=RegFile.registers[rs];
            readData2=RegFile.registers[rt];


            immediate = "";
            //Dacă $s < $t, $d este inițializat cu 1, altfel cu 0
            System.out.println("SLT " + "rS" + rs+ " rT" + rt + " rD" + rd + " in Decode stage:");
            System.out.println("Read Data1 : " + readData1);
            System.out.println("Read Data2 : " + readData2);

            System.out.println("Next PC : " + pc );
            System.out.println("rs : " + rs);
            System.out.println("rt : " + rt);
            System.out.println("rd : " + rd);
            MainUnit.ContUnit(op);
            System.out.println("\n\n");

        }
        if(op.equals("1000000000")) {
            // C format
            String rs2 = inst.substring(10,16);
            String rt2 = inst.substring(16,22);
            String rd2 = inst.substring(22,32);
            rs = convertToDecimal(rs2);
            rt = convertToDecimal(rt2);
            readData1=RegFile.registers[rs];
            readData2=RegFile.registers[rt];
            rd = convertToDecimal(rd2);
            immediate = "";
            //Dacă $s < $t, $d este inițializat cu 1, altfel cu 0
            System.out.println("OR " + "rS" + rs+ " rT" + rt + " rD" + rd + " in Decode stage:");
            System.out.println("Read Data1 : " + readData1);
            System.out.println("Read Data2 : " + readData2);

            System.out.println("Next PC : " + pc );
            System.out.println("rs : " + rs);
            System.out.println("rt : " + rt);
            System.out.println("rd : " + rd);
            MainUnit.ContUnit(op);
            System.out.println("\n\n");

        }
        if(op.equals("1000000001")) {
            // C format
            String rs2 = inst.substring(10,16);
            String rt2 = inst.substring(16,22);
            String rd2 = inst.substring(22,32);
            rs = convertToDecimal(rs2);
            rt = convertToDecimal(rt2);
            readData1=RegFile.registers[rs];
            readData2=RegFile.registers[rt];
            rd = convertToDecimal(rd2);
            immediate = "";
            //Dacă $s < $t, $d este inițializat cu 1, altfel cu 0
            System.out.println("XOR " + "rS" + rs+ " rT" + rt + " rD" + rd + " in Decode stage:");
            System.out.println("Read Data1 : " + readData1);
            System.out.println("Read Data2 : " + readData2);

            System.out.println("Next PC : " + pc );
            System.out.println("rs : " + rs);
            System.out.println("rt : " + rt);
            System.out.println("rd : " + rd);
            MainUnit.ContUnit(op);
            System.out.println("\n\n");

        }


        if(op.equals("0000001110")) {
            // U format
            immediate = inst.substring(10,32);
            readData1="";
            readData2="";
            SignExtendU(immediate);
            pc = sum(pc,signExtendOut); // in EX!!!
            System.out.println("J " + convertToDecimal(immediate) + " in Decode stage:");
            System.out.println("Read Data1 : " + readData1);
            System.out.println("Read Data2 : " + readData2);
            System.out.println("Sign Extend : " + signExtendOut);
            System.out.println("Next PC : " + pc);
            MainUnit.ContUnit(op);
            System.out.println("\n\n");

        }
        MainController.IDEX[MainController.IDEXindex] = inst;
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = pc;
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = op;
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = convertToBinary(rs);
        //System.out.println( "rsss " + MainController.IDEX[MainController.IDEXindex]);
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = convertToBinary(rt);
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = convertToBinary(rd);
        MainController.IDEXindex += 1 ;
        MainController.IDEX[MainController.IDEXindex] = immediate;
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = signExtendOut;
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = readData1;
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = readData2;
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = RegDst;
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = RegWrite;
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = PCSrc;
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = MemRead;
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = MemWrite;
        MainController.IDEXindex += 1;
        MainController.IDEX[MainController.IDEXindex] = MemToReg;
        MainController.IDEXindex += 1;
    }



    public static void SignExtendU(String bits) {
        String extend = "";
        char c = bits.charAt(0);
        for(int i=0;i<10;i++) {
            extend += c;
        }
        signExtendOut = extend + bits;
//		System.out.println("sign extended:" + signExtendOut);
    }

    public static String sum(String b1, String b2) {
        int len1 = b1.length(); int len2 = b2.length();
        int carry = 0; String res = "";
        int maxLen = Math.max(len1, len2);
        for (int i = 0; i < maxLen; i++) {

            int p = i < len1 ? b1.charAt(len1 - 1 - i) - '0' : 0;
            int q = i < len2 ? b2.charAt(len2 - 1 - i) - '0' : 0;
            int tmp = p + q + carry; carry = tmp / 2; res = tmp % 2 + res; }
        return (carry == 0) ? res : "1" + res;
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



