package com.esprit.Service;

/**
 *
 * @author shai
 */
public interface CameraListener {
    public void onError(CameraEvent ev);
    
    public void onImage(CameraEvent ev);
    
    public void onVideo(CameraEvent ev);
    
}
