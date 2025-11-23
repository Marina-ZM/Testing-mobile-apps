package com.techyourchance.testdoublesfundamentals.exercise4.networking;

import com.techyourchance.testdoublesfundamentals.example4.networking.NetworkErrorException;
import com.techyourchance.testdoublesfundamentals.exercise4.networking.UserProfileHttpEndpointSync.EndpointResult;
import com.techyourchance.testdoublesfundamentals.exercise4.networking.UserProfileHttpEndpointSync.EndpointResultStatus;

public class UserProfileHttpEndpointSyncTD implements UserProfileHttpEndpointSync{
private String mUserId;
private EndpointResult mEndpointResult;
private NetworkErrorException mNetworkErrorException;
public void setEndpointResult(EndpointResult endpointResult){
mEndpointResult = endpointResult;
}
public void setNetworkErrorException(NetworkErrorException networkErrorException){
mNetworkErrorException = networkErrorException;
}
@Override
public EndpointResult getUserProfile(String userId) throws NetworkErrorException{
mUserId = userId;
if(mNetworkErrorException != null){
throw mNetworkErrorException;
}
if(mEndpointResult == null){
return new EndpointResult(EndpointResultStatus.SUCCESS, "John Doe", "http://example.com/image.png");
}
return mEndpointResult;
}
public String getUserId(){
return mUserId;
}
}