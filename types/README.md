# Types for QR Code library

Type definitions for the [Enonic XP QR Code library](https://github.com/enonic/lib-qrcode).

## Install

```bash
npm i --save-dev @enonic-types/lib-qrcode
```

Versions track the library itself, so install the same version as the `com.enonic.lib:lib-qrcode` dependency in your `build.gradle`.

## Setup

Add lib-qrcode to `compilerOptions.paths` in the `tsconfig.json` file used for your application's server-side TypeScript code:

```json
{
  "compilerOptions": {
    "paths": {
      "/lib/qrcode": ["./node_modules/@enonic-types/lib-qrcode"]
    }
  }
}
```

## Use

```ts
import {generateQrCode} from '/lib/qrcode';

export function get() {
    const image = generateQrCode({
        text: 'https://enonic.com',
        size: 250,
    });

    return {
        body: image,
        contentType: 'image/png',
    };
}
```

All imports from `/lib/qrcode` should now be typed.

## API

### `generateQrCode(params: GenerateQrCodeParams): ByteSource`

Generates a PNG image with a QR code that encodes the specified text. The returned stream can be set as the body of an HTTP response, stored in a node or content, or manipulated using lib-io.

### `GenerateQrCodeParams`

| Property | Type     | Required | Description                                                               |
|----------|----------|----------|---------------------------------------------------------------------------|
| `text`   | `string` | Yes      | The text or URL to be encoded in the QR code.                             |
| `size`   | `number` | No       | The width and height of the square image, in pixels. Defaults to `250`.   |

## Documentation

[QR Code library](https://developer.enonic.com/docs/qr-code-library/)
