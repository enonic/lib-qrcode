package com.enonic.lib.qrcode;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.EnumMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.common.io.ByteSource;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeHandler
{
    private static final int BLACK = 0x000000;

    private static final int WHITE = 0xFFFFFF;

    private Integer size;

    private String text;

    public ByteSource generateQrCode()
    {
        final Map<EncodeHintType, Object> hints = new EnumMap<>( EncodeHintType.class );
        hints.put( EncodeHintType.CHARACTER_SET, "UTF-8" );

        final BitMatrix matrix;
        try
        {
            matrix = new QRCodeWriter().encode( text, BarcodeFormat.QR_CODE, size, size, hints );
        }
        catch ( final WriterException e )
        {
            throw new IllegalArgumentException( "Could not encode QR code for the given input", e );
        }

        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try
        {
            ImageIO.write( toImage( matrix ), "PNG", stream );
        }
        catch ( final IOException e )
        {
            throw new UncheckedIOException( e );
        }
        return ByteSource.wrap( stream.toByteArray() );
    }

    private static BufferedImage toImage( final BitMatrix matrix )
    {
        final int width = matrix.getWidth();
        final int height = matrix.getHeight();
        final BufferedImage image = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB );
        for ( int x = 0; x < width; x++ )
        {
            for ( int y = 0; y < height; y++ )
            {
                image.setRGB( x, y, matrix.get( x, y ) ? BLACK : WHITE );
            }
        }
        return image;
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
