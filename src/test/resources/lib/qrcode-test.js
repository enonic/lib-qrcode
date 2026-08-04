var qrCodeLib = require('/lib/qrcode');
var assert = require('/lib/xp/testing');

exports.testGenerateQrCode = function () {
    var result = qrCodeLib.generateQrCode({
        text: 'https://enonic.com',
        size: 250
    });
    assert.assertNotNull(result);
};

exports.testGenerateQrCodeDefaultSize = function () {
    var result = qrCodeLib.generateQrCode({
        text: 'https://enonic.com'
    });
    assert.assertNotNull(result);
};
