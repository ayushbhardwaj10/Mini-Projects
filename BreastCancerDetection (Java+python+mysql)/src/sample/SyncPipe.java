//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


package  sample;

import java.io.InputStream;
import java.io.OutputStream;

class SyncPipe implements Runnable {
    private final OutputStream ostrm_;
    private final InputStream istrm_;

    public SyncPipe(InputStream istrm, OutputStream ostrm) {
        this.istrm_ = istrm;
        this.ostrm_ = ostrm;
    }

    public void run() {
        try {
            byte[] buffer = new byte[1024];
            boolean var2 = false;

            int length;
            while((length = this.istrm_.read(buffer)) != -1) {
                this.ostrm_.write(buffer, 0, length);
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }
}
