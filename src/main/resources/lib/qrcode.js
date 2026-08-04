exports.generateQrCode = function (params) {
    var bean = __.newBean('com.enonic.lib.qrcode.QRCodeHandler');
    bean.setText(__.nullOrValue(params.text) || '');
    bean.setSize(__.nullOrValue(params.size) || 250);
    return bean.generateQrCode();
};
