package com.example.project_ssc;

public class EX {
    public static String ALUresult = "";
    public static String BranchAddressResult = "";
    public static int IDEXindex = 0;

    public static void ex()
    {String inst = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String pc = MainController.IDEX[IDEXindex];
        IDEXindex +=1;
        String op = MainController.IDEX[IDEXindex];
        IDEXindex -=1;
        IDEXindex -=1;
        if(op.equals("0000000001")) {
            executeALCB();
        }
        if(op.equals("0000000010") ||  (op.equals("1000000010"))) {
//            System.out.println("Ajunge aici?");
            executeALCB();
        }
        if(op.equals("0000000011")) {
            executeALCB();
        }
        if(op.equals("0000000100")) {
            executeALCB();
        }
        if(op.equals("0000000101")) {
            executeALCB();
        }
        if(op.equals("0000000110")) {
            executeALCB();
        }
        if(op.equals("0000000111")) {
            executeALCB();
        }
        if(op.equals("0000001000")) {
            executeALCB();
        }
        if(op.equals("0000001001")) {
            executeD();
        }
        if(op.equals("0000001010")) {
            executeD();
        }
        if(op.equals("0000001011")) {
            executeALCB();
        }
        if(op.equals("0000001100")) {
            executeALCB();
        }
        if(op.equals("0000001101") || op.equals("1000000000") || op.equals("1000000001")) {
            executeC();
        }
        if(op.equals("0000001110")) {
            executeU();
        }
    }
    public static void executeALCB() {
       // System.out.println("Äjunge aici?");
        String inst = MainController.IDEX[IDEXindex];
        IDEXindex += 1;

        String pc = MainController.IDEX[IDEXindex];
        IDEXindex +=1;
        String op = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String rsBinary = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        int rs = convertToDecimal(rsBinary);
        String rtBinary = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        int rt = convertToDecimal(rtBinary);
        String rdBinary = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        int rd = convertToDecimal(rdBinary);
        String immediate = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String signExtendOut = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String readData1 = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String readData2 = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String RegDst = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String RegWrite = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String PCSrc = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String MemRead = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String MemWrite = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String MemToReg = MainController.IDEX[IDEXindex];
        IDEXindex += 1;

        if(op.equals("0000000001")) {
                String Operand1 = RegFile.registers[rs];
                String Operand2 = RegFile.registers[rt];
                System.out.println("Op 1 si Op2: " +Operand1  + " " + Operand2);
                ALUresult = ALU.addOp(Operand1, Operand2);

            BranchAddressResult = "";
            System.out.println("ADD " + "rS" + rs + " rT" + rt + " " + " in Execute stage:");
            System.out.println("RD new data : " + ALUresult);
            System.out.println("ALUresult : " +ALUresult );
            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst );
            System.out.println("\n\n");

        }
        if(op.equals("0000000010")) {
            //$t  $s + imm; PC  PC + 4;
            System.out.println("rs " +rs);
            String Operand1 = RegFile.registers[rs];
            System.out.println("Operand 1 si imediatul sunt : " + Operand1 +" "+ immediate);
            ALUresult = ALU.addOp(Operand1,immediate);;
            BranchAddressResult = "";
            System.out.println("ADDi " + "rs" + rs + " rt" + rt + " imm " + convertToDecimal(immediate) + " in Execute stage:");
            System.out.println("RT new data : " + ALUresult);
            System.out.println("ALUresult : " +ALUresult );
            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst );
            System.out.println("\n\n");
        }
        if(op.equals("1000000010")) {
            //$t  $s + imm; PC  PC + 4;
            System.out.println("rs " +rs);
            String Operand1 = RegFile.registers[rs];
            System.out.println("Operand 1 si imediatul sunt : " + Operand1 +" "+ immediate);
            String last10Bits = Operand1.substring(Math.max(Operand1.length() - 10, 0));
            System.out.println(last10Bits);
            ALUresult=ALU.ANDOp(last10Bits, immediate);
            BranchAddressResult = "";
            System.out.println("ANDi " + "rs" + rs + " rt" + rt + " imm " + convertToDecimal(immediate) + " in Execute stage:");
            System.out.println("RT new data : " + ALUresult);
            System.out.println("ALUresult : " +ALUresult );
            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst );
            System.out.println("\n\n");
        }
        if(op.equals("0000000011")) {

                String Operand1 = RegFile.registers[rs];
                String Operand2 = RegFile.registers[rt];
                ALUresult = ALU.subOp(Operand1, Operand2);

            System.out.println("SUB " + "rS" + rs + " rT" + rt + " "  + " in Execute stage:");
            BranchAddressResult = "";
            System.out.println("RD new data : " + ALUresult);
            System.out.println("ALUresult : " +ALUresult );

            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst );
            System.out.println("\n\n");
        }
        if(op.equals("0000000100")) {
                String Operand1 = RegFile.registers[rs];
                String Operand2 = RegFile.registers[rt];
                ALUresult = ALU.multOp(Operand1, Operand2);


            BranchAddressResult = "";
            System.out.println("MULT " + "r" + rs + " r" + rt + " " + " in Execute stage:");
            System.out.println("RD new data : " + ALUresult);
            System.out.println("ALUresult : " +ALUresult );
            System.out.println("register value to write to memory : " + "");
            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst );
            System.out.println("\n\n");
        }
        if(op.equals("0000000101")) {

                String Operand1 = RegFile.registers[rs];
                String Operand2 = RegFile.registers[rt];
                ALUresult = ALU.ANDOp(Operand1, Operand2);

            BranchAddressResult = "";
            System.out.println("AND " + "rS" + rs + " rT" + rt + " " + convertToDecimal(immediate) + " in Execute stage:");
            System.out.println("RD new data : " + ALUresult);
            System.out.println("ALUresult : " +ALUresult );

            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst );
            System.out.println("\n\n");
        }
        if(op.equals("0000000110")) {
            String Operand1 = RegFile.registers[rs];
            String last10Bits = Operand1.substring(Math.max(Operand1.length() - 10, 0));
System.out.println(last10Bits);
ALUresult=ALU.OROp(last10Bits, immediate);
//            ALUresult = ALU.OROp(Operand1, immediate);
            System.out.println("Operand 1: " +Operand1);
            System.out.println("immediat: " +immediate);
            BranchAddressResult = "";
            System.out.println("ORi " + "rS" + rs + " rT" + rt + " " + convertToDecimal(immediate) + " in Execute stage:");
            System.out.println("RT new data : " + ALUresult);
            System.out.println("ALUresult : " +ALUresult );


            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst );
            System.out.println("\n\n");
        }
        if(op.equals("0000000111")) {
            //$d  $t << h; PC  PC + 4;   sll $d, $t, h
            String Operand1 = RegFile.registers[rt];
            ALUresult = ALU.sllOp(Operand1, immediate);
            BranchAddressResult = "";
            System.out.println("SLL " + "rS" + rs + " rT" + rt + " " + convertToDecimal(immediate) + " in Execute stage:");
            System.out.println("RS new data : " + ALUresult);
            System.out.println("ALUresult : " +ALUresult );
            System.out.println("register value to write to memory : " + "");
            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst );
            System.out.println("\n\n");
        }
        if(op.equals("0000001000")) {
            //$d  $t >> h; PC  PC + 4;   sll $d, $t, h
            String Operand1 = RegFile.registers[rt];
            ALUresult = ALU.srlOp(Operand1, immediate);
            BranchAddressResult = "";
            System.out.println("SRL " + "rs" + rs + " rt" + rt + " " + convertToDecimal(immediate) + " in Execute stage:");
            System.out.println("RS new data : " + ALUresult);
            System.out.println("ALUresult : " +ALUresult );
            System.out.println("register value to write to memory : " + "");
            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst );
            System.out.println("\n\n");
        }
        if(op.equals("0000001011")) {
            // se schimba pc -ul cu offsetul
            String Operand1 = RegFile.registers[rs];
            String Operand2 = RegFile.registers[rt];
            int Operand1Dec = convertToDecimal(Operand1);
            int Operand2Dec = convertToDecimal(Operand2);
            if(!(RegFile.registers[Operand1Dec].equals(RegFile.registers[Operand2Dec]))) {
                BranchAddressResult = immediate;
                ALUresult = "";
                System.out.println("BNE " + "rs" + rs + " rt" + rt + " " + convertToDecimal(immediate) + " in Execute stage:");
                System.out.println("pc new  value  : " + "");
                System.out.println("BranchAddressResult : " + BranchAddressResult);

                System.out.println("ALUresult : " +ALUresult );
                System.out.println("register value to write to memory : " + "");
                System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
                System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
                System.out.println("EXT Controls : " + "RegDst : " + RegDst );
                System.out.println("\n\n");
            }
            else {
                BranchAddressResult = pc;
                ALUresult = "";
                System.out.println("BNE " + "rs" + rs + " rt" + rt + " " + convertToDecimal(immediate) + " in Execute stage:");
                System.out.println("pc  new value : " + "");
                System.out.println("BranchAddressResult : " + BranchAddressResult);
                System.out.println("ALUresult : " +ALUresult );
                System.out.println("register value to write to memory : " + "");
                System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
                System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + ID.MemWrite + " PCSrc : " + ID.PCSrc);
                System.out.println("EXT Controls : " + "RegDst : " + RegDst );
                System.out.println("\n\n");
            }
        }
        if(op.equals("0000001100")) {
            String Operand1 = RegFile.registers[rs];
            String Operand2 = RegFile.registers[rt];
            int Operand1Dec = convertToDecimal(Operand1);
            int Operand2Dec = convertToDecimal(Operand2);
            int rsdec = convertToDecimal(RegFile.registers[Operand1Dec]);
            int rtdec = convertToDecimal(RegFile.registers[Operand2Dec]);
            if(rsdec > rtdec) {
                BranchAddressResult = pc;
                ALUresult = "";
                System.out.println("BGT " + "rs" + rs + " rt" + rt + " " + convertToDecimal(immediate) + " in Execute stage:");
                System.out.println("pc new value : " + "");
                System.out.println("BranchAddressResult : " + BranchAddressResult);
                System.out.println("ALUresult : " +ALUresult );
                System.out.println("register value to write to memory : " + "");
                System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
                System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
                System.out.println("EXT Controls : " + "RegDst : " + RegDst );
                System.out.println("\n\n");
            }
            else {
                BranchAddressResult = "";
                ALUresult = "";
                System.out.println("BGT " + "rs" + rs + " rt" + rt + " " + convertToDecimal(immediate) + " in Execute stage:");
                System.out.println("pc value the same: ");
                System.out.println("ALUresult : " +ALUresult );
                System.out.println("register value to write to memory : " + "");
                System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
                System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
                System.out.println("EXT Controls : " + "RegDst : " + RegDst );
                System.out.println("\n\n");
            }
        }
        MainController.EXMEM[MainController.EXMEMindex] = inst;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = pc;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = op;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = convertToBinary(rs);
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = convertToBinary(rt);
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = convertToBinary(rd);
        MainController.EXMEMindex += 1 ;
        MainController.EXMEM[MainController.EXMEMindex] = immediate;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = signExtendOut;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = readData1;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = readData2;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = RegDst;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = RegWrite;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = PCSrc;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = MemRead;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = MemWrite;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = MemToReg;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = ALUresult;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = BranchAddressResult;
        MainController.EXMEMindex += 1;
    }
    public static void executeD() {
        String inst = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String pc = MainController.IDEX[IDEXindex];
        IDEXindex +=1;
        String op = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String rxBinary = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        int rs = convertToDecimal(rxBinary);
        String ryBinary = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        int rt = convertToDecimal(ryBinary);
        String rzBinary = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        int rd = convertToDecimal(rzBinary);
        String immediate = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String signExtendOut = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String readData1 = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String readData2 = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String RegDst = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String RegWrite = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String PCSrc = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String MemRead = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String MemWrite = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String MemToReg = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        if(op.equals("0000001001")) {
            // $t  MEM[$s + offset]; PC  PC + 4;
            String Operand1 = RegFile.registers[rs];
            ALUresult = ALU.addOp(Operand1, immediate);
            System.out.println("LW  " + "rt <-" + rt + " <==" + "  Mem[rs+offset=]" + RegFile.registers[rt]+ " + " + immediate +" in Execute stage:");
            System.out.println("ALUresult : " +ALUresult );
            System.out.println("register new : " + ALUresult);
            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst );
            System.out.println("\n\n");
        }
        if(op.equals("0000001010")) {
            //MEM[$s + offset]  $t; PC  PC + 4;
            String Operand1 = RegFile.registers[rs];
            System.out.println("Operand1 : " + Operand1);
            System.out.println("imediat :" + immediate);
            ALUresult = ALU.addOp(Operand1, immediate);

            System.out.println("SW  " + "Mem[rs+offset] <- " + ALUresult + " <== " + "rt=" +" "+RegFile.registers[rt] +" in Execute stage:");

            System.out.println("ALUresult : " +ALUresult );
            System.out.println("register value to write to memory : " + RegFile.registers[rt]);
            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst );
            System.out.println("\n\n");

        }

        MainController.EXMEM[MainController.EXMEMindex] = inst;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = pc;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = op;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = convertToBinary(rs);
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = convertToBinary(rt);
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = convertToBinary(rd);
        MainController.EXMEMindex += 1 ;
        MainController.EXMEM[MainController.EXMEMindex] = immediate;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = signExtendOut;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = readData1;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = readData2;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = RegDst;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = RegWrite;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = PCSrc;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = MemRead;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = MemWrite;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = MemToReg;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = ALUresult;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = BranchAddressResult;
        MainController.EXMEMindex += 1;
    }
    public static void executeC() {
        String inst = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String pc = MainController.IDEX[IDEXindex];
        IDEXindex +=1;
        String op = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String rxBinary = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        int rx = convertToDecimal(rxBinary);
        String ryBinary = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        int ry = convertToDecimal(ryBinary);
        String rzBinary = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        int rz = convertToDecimal(rzBinary);
        String immediate = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String signExtendOut = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String readData1 = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String readData2 = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String RegDst = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String RegWrite = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String PCSrc = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String MemRead = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String MemWrite = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String MemToReg = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String Operand1 = RegFile.registers[rx];
        String Operand2 = RegFile.registers[ry];
        if (op.equals("0000001101")) {
            ALUresult = ALU.sltOp(Operand1, Operand2);
            BranchAddressResult = "";
            //PC  PC + 4; if $s < $t $d  1; else $d  0;
            System.out.println("SLT " + "rs" + rx + " rt" + ry + " rd" + rz + " in Execute stage:");
            System.out.println("rd new data : " + ALUresult);
            System.out.println("ALUresult : " + ALUresult);

            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst);
            System.out.println("\n\n");
        }
        if (op.equals("1000000000"))
        {
            ALUresult = ALU.orrOp(Operand1, Operand2);
            BranchAddressResult = "";
            //PC  PC + 4; if $s < $t $d  1; else $d  0;
            System.out.println("OR " + "rs" + rx + " rt" + ry + " rd" + rz + " in Execute stage:");
            System.out.println("rd new data : " + ALUresult);
            System.out.println("ALUresult : " + ALUresult);

            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst);
            System.out.println("\n\n");
        }
        if (op.equals("1000000001"))
        {
            ALUresult = ALU.xOROp(Operand1, Operand2);
            BranchAddressResult = "";
            //PC  PC + 4; if $s < $t $d  1; else $d  0;
            System.out.println("XOR " + "rs" + rx + " rt" + ry + " rd" + rz + " in Execute stage:");
            System.out.println("rd new data : " + ALUresult);
            System.out.println("ALUresult : " + ALUresult);

            System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
            System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
            System.out.println("EXT Controls : " + "RegDst : " + RegDst);
            System.out.println("\n\n");
        }
        MainController.EXMEM[MainController.EXMEMindex] = inst;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = pc;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = op;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = convertToBinary(rx);
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = convertToBinary(ry);
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = convertToBinary(rz);
        MainController.EXMEMindex += 1 ;
        MainController.EXMEM[MainController.EXMEMindex] = immediate;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = signExtendOut;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = readData1;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = readData2;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = RegDst;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = RegWrite;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = PCSrc;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = MemRead;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = MemWrite;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = MemToReg;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = ALUresult;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = BranchAddressResult;
        MainController.EXMEMindex += 1;
    }
    public static void executeU() {
        String inst = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String pc = MainController.IDEX[IDEXindex];
        IDEXindex +=1;
        String op = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String rxBinary = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        int rx = convertToDecimal(rxBinary);
        String ryBinary = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        int ry = convertToDecimal(ryBinary);
        String rzBinary = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        int rz = convertToDecimal(rzBinary);
        String immediate = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String signExtendOut = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String readData1 = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String readData2 = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String RegDst = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String RegWrite = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String PCSrc = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String MemRead = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String MemWrite = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        String MemToReg = MainController.IDEX[IDEXindex];
        IDEXindex += 1;
        BranchAddressResult = IF.pc;
        ALUresult = "";
        System.out.println("J " + convertToDecimal(immediate) + " in Execute stage:");
        System.out.println("pc new value : " + "");
        System.out.println("ALUresult : " +ALUresult );

        System.out.println("WB Controls : " + "MemToReg : " + MemToReg + " RegWrite : " + RegWrite);
        System.out.println("MEM Controls : " + "MemRead : " + MemRead + " MemWrite : " + MemWrite + " PCSrc : " + PCSrc);
        System.out.println("EXT Controls : " + "RegDst : " + RegDst );
        MainController.EXMEM[MainController.EXMEMindex] = inst;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = pc;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = op;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = convertToBinary(rx);
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = convertToBinary(ry);
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = convertToBinary(rz);
        MainController.EXMEMindex += 1 ;
        MainController.EXMEM[MainController.EXMEMindex] = immediate;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = signExtendOut;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = readData1;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = readData2;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = RegDst;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = RegWrite;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = PCSrc;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = MemRead;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = MemWrite;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = MemToReg;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = ALUresult;
        MainController.EXMEMindex += 1;
        MainController.EXMEM[MainController.EXMEMindex] = BranchAddressResult;
        MainController.EXMEMindex += 1;
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

