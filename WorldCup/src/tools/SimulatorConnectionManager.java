/**
The MIT License (MIT)
Copyright (c) 2015 LittleMonkey Ltd.
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package tools;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author nick
 */
public class SimulatorConnectionManager implements NativeConnectivity {

    public int getConnectionStatus() {
        final int[] returnValue = new int[1];
        ConnectionRequest r = new ConnectionRequest() {

            @Override
            protected void readResponse(InputStream input) throws IOException {
                returnValue[0] = 2;
            }

        };
        r.setUrl(NetworkManager.getAutoDetectURL());
        r.setPost(false);
        r.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(r);
        return returnValue[0];

    }

    public boolean isSupported() {
        return true;
    }

}
