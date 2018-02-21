package com.l.okal;

import android.app.*;
import android.os.*;
import android.app.admin.*;
import android.content.*;

public class A extends Activity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    	DevicePolicyManager policyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
	ComponentName componentName = new ComponentName(this, android.app.admin.DeviceAdminReceiver.class);
    	boolean isActive = policyManager.isAdminActive(componentName);
        if (isActive) {
        	 policyManager.lockNow();
        }else{
			 startActivityForResult(new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName), 0);
    	}
	   android.os.Process.killProcess(android.os.Process.myPid());
    }
}
