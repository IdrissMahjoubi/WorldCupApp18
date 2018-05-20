
package tools;

import com.codename1.system.NativeInterface;
import com.codename1.system.NativeLookup;

/**
 *
 * @author nick
 */
public class Connectivity {

    static NativeConnectivity connectionManager;

    public enum ConnectionState {
        DISCONNECTED,
        WIFI,
        MOBILE
    };

    public static boolean isConnected() {
        return getConnectionState() != ConnectionState.DISCONNECTED;
    }

    public static ConnectionState getConnectionState() {
        int status = getConnectionManager().getConnectionStatus();
        switch(status) {
            case 0:
            default:
                return ConnectionState.DISCONNECTED;
            case 1:
                return ConnectionState.MOBILE;
            case 2:
                return ConnectionState.WIFI;
        }
    }

    private static NativeConnectivity getConnectionManager() {
        if (connectionManager == null) {
            try {
                NativeInterface ni = NativeLookup.create(NativeConnectivity.class);
                if (ni != null) {
                    connectionManager = (NativeConnectivity) ni;
                }
            } catch (Exception e) {

            }
        }
        if (connectionManager == null || !connectionManager.isSupported()) {
            connectionManager = new SimulatorConnectionManager();
        }
        return connectionManager;
    }

}
