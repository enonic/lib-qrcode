import type { ByteSource } from "@enonic-types/core";

declare module "/lib/qrcode" {
    interface GenerateQrCodeParams {
        /**
         * The text or URL to be encoded in the QR code.
         */
        text: string;

        /**
         * The width and height of the square image generated, in pixels.
         *
         * @default 250
         */
        size?: number;
    }

    /**
     * Generates a PNG image with a QR Code that encodes the specified text.
     *
     * @param params Options controlling the generated QR code.
     * @returns Stream containing the generated PNG image.
     */
    export function generateQrCode(params: GenerateQrCodeParams): ByteSource;
}

export {};
