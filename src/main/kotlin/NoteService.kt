class NoteService: CrudService<Note> () {

   fun addComment (noteId : Int, comment : Comment) {
      comment.noteId = noteId
      var commentNextId = 1
      comment.commentId = commentNextId++
      list.find {it.id == noteId}?.comments?.add(comment)
   }

}