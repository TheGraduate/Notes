class Note (id : Int,var title: String, var textNote : String): CrudItem(id) {

    val comments = mutableListOf<Comment>()
    val deleteComments = mutableListOf<Comment>()

    fun restoreComment (idComment: Int): Boolean {

        for (deleteComment in deleteComments) {
            if (idComment == deleteComment.commentId) {
                comments.add(deleteComment)
                return true
            }
        }
        return false
    }

    fun editComment (idComment: Int, updateText: String): Boolean {

        for(commentInComments in comments) {
            if (idComment == commentInComments.commentId) {
                commentInComments.textComment = updateText
                return true
            }
        }
        return false
    }

    fun deleteComment (idComment: Int): Boolean {

        for(commentInComments in comments) {
            if (idComment == commentInComments.commentId) {
                deleteComments.add(commentInComments)
                comments.remove(commentInComments)
                return true
            }
        }
        return false
    }

    fun deleteAllComment (idNote: Int) {

        for(commentInComments in comments) {
            if (idNote == commentInComments.noteId) {
                comments.remove(commentInComments)
            }
        }
    }

    fun getAllComments (): Comment? {

        if (comments.isNotEmpty()) {
            for (commentInComments in comments) {
                return commentInComments
            }
        }
        return null
    }

}


