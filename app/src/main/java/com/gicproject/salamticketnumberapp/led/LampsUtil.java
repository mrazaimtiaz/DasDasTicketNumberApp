package com.gicproject.salamticketnumberapp.led;

import java.io.IOException;


public class LampsUtil {
	
	 public static int num1;
	public static int  num2;

	public static int num7;

	public static int  numL1;
	public static int  numB_off;
	public static int  numR_off;
	public static int  numG_off;

	public static int  numB_Lamps;
	public static int  numR_Lamps;
	public static int  numG_Lamps;

	public static int numB;   //blue values
	public static int numG;   //green values
	public static int numR;
	public static int  numL=stringsimpleToByte("f4");

	public static Object lock;

	
	public LampsUtil(){

		num1=stringsimpleToByte("55");
		num2=stringsimpleToByte("AA");
		numB=stringsimpleToByte("11");
		numR=stringsimpleToByte("11");
		numG=stringsimpleToByte("11");
		
		numB_off = stringsimpleToByte("00");
		numR_off = stringsimpleToByte("00");
		numG_off = stringsimpleToByte("00");
		
		numB_Lamps = stringsimpleToByte("33");
		numR_Lamps = stringsimpleToByte("33");
		numG_Lamps = stringsimpleToByte("33");
		
		numL1 = stringsimpleToByte("f4");
		
		num7 = stringsimpleToByte("88");
		
		lock = new Object();
		
	}
	
	public static byte[] intToByteArray(int a) {  
	    return new byte[] {     
	        (byte) (a & 0xFF)  
	    };  
	}
	
	public static int  stringsimpleToByte(String in){
        int b=Integer.parseInt(in,16);
        return b;
        //Arrays.fill(b, (byte)t);
    }
	
	public static void AllOnLamps() throws IOException{                   //All the lights    
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<52; i++){	
			UartSend.out.write(intToByteArray(numL1));
			UartSend.out.write(intToByteArray(numB));
			UartSend.out.write(intToByteArray(numR));
			UartSend.out.write(intToByteArray(numG));	
			
		}

		UartSend.out.write(intToByteArray(num7));
	}

	public static void AllOffLamps() throws IOException{               //All the lights went out
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<52; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
		
	}
	
	public static void AllRLamps() throws IOException{                //All of the red light
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<52; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_Lamps));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void AllBLamps() throws IOException{
		num1=stringsimpleToByte("55");
		num2=stringsimpleToByte("AA");

		numB_off = stringsimpleToByte("00");
		numR_off = stringsimpleToByte("00");
		numG_off = stringsimpleToByte("00");

		numB_Lamps = stringsimpleToByte("33");
		numR_Lamps = stringsimpleToByte("33");
		numG_Lamps = stringsimpleToByte("33");

		numL1 = stringsimpleToByte("f4");

		num7 = stringsimpleToByte("88");//All of the blue light
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<52; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_Lamps));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void AllGLamps() throws IOException{              //All of the green light
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<52; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_Lamps));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_R1() throws IOException{              //The first red light is bright
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<51; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G1() throws IOException{            //The first green light is bright
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<51; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B1() throws IOException{          //The first blue light is bright
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<51; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	
	public static void Lamps_R2() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<1; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<50; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G2() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<1; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<50; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B2() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<1; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<50; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_R3() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<2; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<49; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G3() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<2; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<49; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B3() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<2; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<49; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_R4() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<3; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<48; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G4() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<3; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<48; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B4() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<3; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<48; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//5
	public static void Lamps_R5() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<4; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<47; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G5() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<4; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<47; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B5() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<4; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<47; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	//6
	public static void Lamps_R6() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<5; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<46; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G6() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<5; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<46; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B6() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<5; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<46; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//7
	public static void Lamps_R7() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<6; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<45; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G7() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<6; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<45; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B7() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<6; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<45; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	//8
	public static void Lamps_R8() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<7; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<44; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G8() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<7; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<44; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B8() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<7; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<44; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
  //9
	
	public static void Lamps_R9() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<8; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<43; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G9() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<8; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<43; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B9() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<8; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<43; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//10
	
	public static void Lamps_R10() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<9; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<42; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G10() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<9; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<42; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B10() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<9; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<42; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//11
	public static void Lamps_R11() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<10; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<41; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G11() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<10; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<41; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B11() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<10; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<41; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//12
	
	public static void Lamps_R12() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<11; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<40; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G12() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<11; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<40; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B12() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<11; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<40; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//13
	public static void Lamps_R13() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<12; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<39; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G13() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<12; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<39; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B13() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<12; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<39; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	//14
	public static void Lamps_R14() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<13; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<38; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G14() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<13; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<38; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B14() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<13; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<38; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	//15
	public static void Lamps_R15() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<14; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<37; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G15() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<14; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<37; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B15() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<14; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<37; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//16
	
	public static void Lamps_R16() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<15; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<36; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G16() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<15; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<36; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B16() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<15; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<36; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//17
	
	public static void Lamps_R17() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<16; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<35; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G17() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<16; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<35; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B17() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<16; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<35; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//18
	
	public static void Lamps_R18() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<17; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<34; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G18() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<17; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<34; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B18() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<17; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<34; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//19
	
	public static void Lamps_R19() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<18; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<33; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G19() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<18; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<33; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B19() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<18; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<33; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//20
	public static void Lamps_R20() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<19; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<32; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G20() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<19; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<32; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B20() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<19; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<32; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//21
	public static void Lamps_R21() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<20; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<31; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G21() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<20; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<31; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B21() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<20; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<31; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//22
	
	public static void Lamps_R22() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<21; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<30; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G22() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<21; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<30; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B22() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<21; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<30; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//23
	public static void Lamps_R23() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<22; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<29; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G23() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<22; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<29; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B23() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<22; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<29; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//24
	public static void Lamps_R24() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<23; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<28; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G24() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<23; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<28; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B24() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<23; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<28; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//25
	public static void Lamps_R25() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<24; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<27; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G25() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<24; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<27; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B25() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<24; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<27; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//26
	public static void Lamps_R26() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<25; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<26; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G26() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<25; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<26; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B26() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<25; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<26; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	//27
	public static void Lamps_R27() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<26; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<25; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G27() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<26; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<25; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B27() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<26; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<25; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//28
	public static void Lamps_R28() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<27; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<24; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G28() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<27; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<24; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B28() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<27; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<24; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		
		UartSend.out.write(intToByteArray(num7));
	}
	//29
	public static void Lamps_R29() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<28; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<23; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G29() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<28; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<23; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B29() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<28; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<23; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//30
	public static void Lamps_R30() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<29; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<22; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G30() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<29; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<22; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B30() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<29; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<22; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//31
	public static void Lamps_R31() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<30; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<21; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G31() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<30; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<21; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B31() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<30; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<21; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//32
	public static void Lamps_R32() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<31; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<20; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G32() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<31; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<20; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B32() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<31; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<20; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//33
	public static void Lamps_R33() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<32; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<19; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G33() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<32; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<19; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B33() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<32; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<19; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//34
	public static void Lamps_R34() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<33; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<18; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G34() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<33; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<18; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B34() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<33; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<18; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//35
	public static void Lamps_R35() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<34; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<17; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G35() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<34; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<17; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B35() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<34; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<17; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	//36
	public static void Lamps_R36() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<35; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<16; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G36() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<35; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<16; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B36() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<35; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<16; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//37
	public static void Lamps_R37() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<36; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<15; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G37() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<36; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<15; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B37() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<36; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<15; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//38
	public static void Lamps_R38() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<37; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<14; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G38() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<37; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<14; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B38() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<37; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<14; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//39
	public static void Lamps_R39() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<38; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<13; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G39() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<38; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<13; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B39() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<38; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<13; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	//40
	public static void Lamps_R40() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<39; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<12; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G40() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<39; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<12; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B40() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<39; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<12; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	//41
	public static void Lamps_R41() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<40; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<11; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G41() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<40; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<11; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B41() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<40; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<11; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	//42
	public static void Lamps_R42() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<41; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<10; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G42() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<41; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<10; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B42() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<41; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<10; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//43
	public static void Lamps_R43() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<42; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<9; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G43() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<42; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<9; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B43() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<42; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<9; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//44
	
	public static void Lamps_R44() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<43; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<8; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G44() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<43; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<8; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B44() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<43; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<8; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//45
	public static void Lamps_R45() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<44; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<7; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G45() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<44; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<7; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B45() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<44; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<7; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//46
	public static void Lamps_R46() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<45; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<6; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G46() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<45; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<6; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B46() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<45; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<6; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//47
	public static void Lamps_R47() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<46; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<5; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G47() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<46; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<5; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B47() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<46; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<5; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//48
	public static void Lamps_R48() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<47; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<4; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G48() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<47; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<4; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B48() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<47; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<4; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//49
	public static void Lamps_R49() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<48; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<3; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G49() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<48; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<3; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B49() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<48; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<3; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//50
	public static void Lamps_R50() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<49; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<2; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G50() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<49; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<2; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B50() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<49; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<2; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//51
	
	public static void Lamps_R51() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<50; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<1; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G51() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<50; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<1; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B51() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<50; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<1; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	//52
	public static void Lamps_R52() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<51; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_Lamps));
		UartSend.out.write(intToByteArray(numG_off));
		
		for( int i=0; i<0; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_G52() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<51; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_off));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_Lamps));
		
		for( int i=0; i<0; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
	public static void Lamps_B52() throws IOException{
		UartSend.out.write(intToByteArray(num1));
		UartSend.out.write(intToByteArray(num2));
		for( int i=0; i<51; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}	
		UartSend.out.write(intToByteArray(numL));
		UartSend.out.write(intToByteArray(numB_Lamps));
		UartSend.out.write(intToByteArray(numR_off));
		UartSend.out.write(intToByteArray(numG_off));
		for( int i=0; i<0; i++){	
			UartSend.out.write(intToByteArray(numL));
			UartSend.out.write(intToByteArray(numB_off));
			UartSend.out.write(intToByteArray(numR_off));
			UartSend.out.write(intToByteArray(numG_off));
		}
		UartSend.out.write(intToByteArray(num7));
	}
	
}
