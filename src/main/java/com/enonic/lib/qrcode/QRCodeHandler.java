package com.enonic.lib.qrcode;

import java.io.ByteArrayOutputStream;

import com.google.common.io.ByteSource;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

public class QRCodeHandler
{
    private Integer size;

    private String text;

    public ByteSource generateQrCode()
    {
        ByteArrayOutputStream stream = QRCode.from( text ).
            withSize( size, size ).
            to( ImageType.PNG ).
            stream();
        return ByteSource.wrap( stream.toByteArray() );
    }

    public void setSize( final Integer size )
    {
        this.size = size;
    }

    public void setText( final String text )
    {
        this.text = text;
    }
}
