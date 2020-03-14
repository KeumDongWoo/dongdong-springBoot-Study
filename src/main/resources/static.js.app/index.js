var main = {
    init : function () {
        var _this = this;
        $('#btn_save').on('click',function () {
            _this.save()
        })
    },
    save : function () {
        var data = {
            title : $('#title').val(),
            author : $("#author").val(),
            content : $("#content").val()
        }

        $.ajax({
            type:'post'
            , url : 'api/v1/posts'
            , dataType : "json"
            , contentType:'application/json'
            , data : JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었씁니다.');
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

        index.init();
    }
}