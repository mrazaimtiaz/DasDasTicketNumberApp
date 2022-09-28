package com.gicproject.salamticketnumberapp.led;

import java.io.FileOutputStream;

import android_serialport_api.SerialPort;

public class UartSend {
	public static FileOutputStream out = null;


	public static Thread UartAllOn(final SerialPort sp, final String name) {
		LedActivity.lock = new Object();
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.AllOnLamps();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartAllOff(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.AllOffLamps();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartAllR(final SerialPort sp, final String name) {
		LedActivity.lock = new Object();
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.AllRLamps();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartAllG(final SerialPort sp, final String name) {
		LedActivity.lock = new Object();
		return new Thread(new Runnable() {
			@Override
			public void run() {
				if (LedActivity.lock == null) {
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.AllGLamps();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartAllB(final SerialPort sp, final String name) {
		LedActivity.lock = new Object();
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.AllBLamps();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartR_1(final SerialPort sp, final String name) {
		LedActivity.lock = new Object();
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R1();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_1(final SerialPort sp, final String name) {
		LedActivity.lock = new Object();
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G1();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_1(final SerialPort sp, final String name) {
		LedActivity.lock = new Object();
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B1();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	
	public static Thread UartR_2(final SerialPort sp, final String name) {
		LedActivity.lock = new Object();
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R2();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_2(final SerialPort sp, final String name) {
		LedActivity.lock = new Object();
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G2();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_2(final SerialPort sp, final String name) {
		LedActivity.lock = new Object();
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B2();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartR_3(final SerialPort sp, final String name) {
		LedActivity.lock = new Object();
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R3();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_3(final SerialPort sp, final String name) {
		LedActivity.lock = new Object();
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G3();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_3(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B3();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartR_4(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R4();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_4(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G4();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_4(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B4();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//5
	public static Thread UartR_5(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R5();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_5(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G5();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_5(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B5();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//6
	public static Thread UartR_6(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R6();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_6(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G6();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_6(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B6();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//7
	
	public static Thread UartR_7(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R7();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_7(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G7();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_7(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B7();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	//8
	public static Thread UartR_8(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R8();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_8(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G8();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_8(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B8();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//9
	public static Thread UartR_9(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R9();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_9(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G9();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_9(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B9();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//10
	public static Thread UartR_10(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R10();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_10(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G10();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_10(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B10();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//11
	public static Thread UartR_11(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R11();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_11(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G11();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_11(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B11();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//12
	
	public static Thread UartR_12(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R12();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_12(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G12();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_12(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B12();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//13
	public static Thread UartR_13(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R13();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_13(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G13();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_13(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B13();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	//14
	public static Thread UartR_14(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R14();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_14(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G14();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_14(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B14();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	//15
	public static Thread UartR_15(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R15();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_15(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G15();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_15(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B15();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//16
	public static Thread UartR_16(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R16();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_16(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G16();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_16(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B16();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	//17
	
	public static Thread UartR_17(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R17();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_17(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G17();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_17(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B17();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	//18
	public static Thread UartR_18(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R18();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_18(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G18();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_18(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B18();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//19
	public static Thread UartR_19(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R19();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_19(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G19();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_19(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B19();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//20	
	public static Thread UartR_20(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R20();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_20(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G20();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_20(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B20();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//21
	public static Thread UartR_21(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R21();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_21(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G21();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_21(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B21();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//22
	public static Thread UartR_22(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R22();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_22(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G22();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_22(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B22();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//23
	
	public static Thread UartR_23(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R23();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_23(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G23();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_23(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B23();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//24
	public static Thread UartR_24(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R24();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_24(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G24();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_24(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B24();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	//25
	public static Thread UartR_25(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R25();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_25(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G25();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_25(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B25();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//26
	public static Thread UartR_26(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R26();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_26(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G26();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_26(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B26();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//27
	public static Thread UartR_27(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R27();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_27(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G27();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_27(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B27();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//28
	public static Thread UartR_28(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R28();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_28(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G28();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_28(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B28();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//29
	public static Thread UartR_29(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R29();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_29(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G29();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_29(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B29();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//30 
	public static Thread UartR_30(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R30();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_30(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G30();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_30(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B30();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//31
	
	public static Thread UartR_31(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R31();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_31(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G31();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_31(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B31();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	//32
	public static Thread UartR_32(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R32();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_32(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G32();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_32(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B32();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//33
	public static Thread UartR_33(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R33();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_33(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G33();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_33(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B33();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//34
	public static Thread UartR_34(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R34();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_34(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G34();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_34(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B34();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//35
	public static Thread UartR_35(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R35();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_35(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G35();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_35(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B35();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//36
	public static Thread UartR_36(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R36();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_36(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G36();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_36(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B36();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//37
	public static Thread UartR_37(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R37();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_37(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G37();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_37(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B37();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//38
	public static Thread UartR_38(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R38();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_38(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G38();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_38(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B38();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//39
	
	public static Thread UartR_39(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R39();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_39(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G39();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_39(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B39();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//40
	public static Thread UartR_40(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R40();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_40(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G40();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_40(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B40();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	//41
	public static Thread UartR_41(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R41();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_41(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G41();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_41(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B41();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//42
	public static Thread UartR_42(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R42();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_42(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G42();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_42(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B42();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//43
	public static Thread UartR_43(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R43();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_43(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G43();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_43(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B43();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//44
	public static Thread UartR_44(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R44();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_44(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G44();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_44(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B44();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//45
	public static Thread UartR_45(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R45();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_45(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G45();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_45(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B45();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//46
	
	public static Thread UartR_46(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R46();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_46(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G46();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_46(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B46();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	//47
	public static Thread UartR_47(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R47();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_47(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G47();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_47(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B47();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//48
	public static Thread UartR_48(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R48();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_48(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G48();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_48(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B48();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//49
	public static Thread UartR_49(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R49();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_49(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G49();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_49(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B49();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//50
	
	public static Thread UartR_50(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R50();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_50(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G50();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_50(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B50();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	//51
	public static Thread UartR_51(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R51();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_51(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G51();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_51(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B51();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	//52
	public static Thread UartR_52(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_R52();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartG_52(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_G52();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public static Thread UartB_52(final SerialPort sp, final String name) {
		return new Thread(new Runnable() {
			@Override
			public void run() {				
				if (LedActivity.lock == null) {	
					System.out.println("lock=null");
				} else {
					try {
						synchronized (LedActivity.lock) {
							out = sp.getFileOutputStream();
							LampsUtil.Lamps_B52();
							out.close();						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
}
