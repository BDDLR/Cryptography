document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.materialboxed');
    console.log("Holis crayolis");
    console.log(elems[0]);
    var instances = M.Materialbox.init(elems, options);

  });