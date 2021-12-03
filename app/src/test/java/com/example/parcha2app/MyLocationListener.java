package com.example.parcha2app;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class MyLocationListener implements LocationListener
{
    @Override
    public void onLocationChanged(Location loc)
    {
        if (loc != null)
        {
            // Do something knowing the location changed by the distance you requested
            methodThatDoesSomethingWithNewLocation(loc);
        }
    }

    private void methodThatDoesSomethingWithNewLocation(Location loc) {
    }

    @Override
    public void onProviderDisabled(String arg0)
    {
        // Do something here if you would like to know when the provider is disabled by the user
    }

    @Override
    public void onProviderEnabled(String arg0)
    {
        // Do something here if you would like to know when the provider is enabled by the   user
    }

    @Override
    public void onStatusChanged(String arg0, int arg1, Bundle arg2)
    {
        // Do something here if you would like to know when the provider status changes
    }
}

