package ficherosDeobjetos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjetOutputStream extends ObjectOutputStream {
    public MiObjetOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected MiObjetOutputStream() throws IOException, SecurityException {

    }

    @Override
    protected void writeStreamHeader() throws IOException {
        super.writeStreamHeader();
    }
}
