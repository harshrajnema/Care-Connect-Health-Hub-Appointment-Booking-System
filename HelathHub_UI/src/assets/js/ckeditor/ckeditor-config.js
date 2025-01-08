(function(){
    
     CKEDITOR.basePath = '../assets/js/ckeditor/'
    // CKEDITOR.plugins.addExternal('wordcount', 'plugins/wordcount/');
    // CKEDITOR.plugins.addExternal('notification', 'plugins/notification/');
    CKEDITOR.plugins.addExternal( 'ckeditor_wiris', '../assets/js/ckeditor/@wiris/mathtype-ckeditor4/plugin.js' );

    CKEDITOR.replace( 'editor', {
        extraPlugins: 'ckeditor_wiris'
    } );
    CKEDITOR.plugins.addExternal('ckeditor_wiris', '../assets/js/ckeditor/plugins/ckeditor_wiris/plugin.js');

    CKEDITOR.editorConfig = function( config ) {
        config.extraPlugins = 'ckeditor_wiris';
        config.extraPlugins = 'MathEx';
        // config.extraPlugins = 'wordcount,notification,ckeditor_wiris';
    }

})();
