package com.zbar.lib;

/**
 * 二维码扫描组类
 * @author zhengji
 *
 */
public class ZbarManager {

	static {
		System.loadLibrary("zbar");
	}

	public native String decode(byte[] data, int width, int height, boolean isCrop, int x, int y, int cwidth, int cheight);
}
