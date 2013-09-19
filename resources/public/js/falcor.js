$('.clojure').each(function() {

    var $this = $(this),
        $code = $this.value();

    CodeMirror.runMode($code, "text/x-clojure", $this);
});
