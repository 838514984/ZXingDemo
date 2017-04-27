package photo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 接收照片事件
 * @author zhengji 
 *
 */
public class PhotoEvent implements Serializable {
	private String mMsg;
	private String mMsg1;
	private ArrayList<String> mMultiList;
	private String className;
	
	public PhotoEvent(String msg) {
        // TODO Auto-generated constructor stub  
        mMsg = msg;
    }  
	
    public PhotoEvent(String className, String msg) {
        // TODO Auto-generated constructor stub  
        mMsg = msg;  
        this.className = className; 
    }  
    
    public PhotoEvent(String className, ArrayList<String> mMultiList) {
        // TODO Auto-generated constructor stub  
    	this.className = className; 
    	this.mMultiList = mMultiList; 
    }  
    
    public PhotoEvent(String className, String msg, String msg1) {
        // TODO Auto-generated constructor stub  
    	mMsg = msg;  
        mMsg1 = msg1; 
        this.className = className;
    }  
    
    public String getMsg(){
        return mMsg;  
    }

    public String getMsg1(){
        return mMsg1;  
    } 
    
    public ArrayList<String> getMultiList(){
        return mMultiList;  
    }

    public String getClassName(){
        return className;  
    }
}