exports.generateQrCode = function (params) {
    var bean = __.newBean('com.enonic.lib.qrcode.QRCodeHandler');
    bean.text = __.nullOrValue(params.text) || '';
    bean.size = __.nullOrValue(params.size) || 250;
    return bean.generateQrCode();
};
