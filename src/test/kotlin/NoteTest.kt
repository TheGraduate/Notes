import org.junit.Test
import org.junit.Assert.*

class NoteTest {

    @Test
    fun editComment_return_true() {

        val note1 = Note(1,"1","1")
        val service = NoteService()
        val comment1 = Comment(1,1,"1")
        service.addNote(note1)
        service.addComment(1,comment1)

        val result = note1.editComment(1,"1")

        assertTrue(result)
    }

    @Test
    fun editComment_return_false() {

        val note1 = Note(1,"1","1")
        val service = NoteService()
        val comment1 = Comment(1,1,"1")
        service.addComment(1,comment1)

        val result = note1.editComment(2,"1")

        assertFalse(result)
    }

    @Test
    fun deleteComment_return_true() {

        val note1 = Note(1,"1","1")
        val service = NoteService()
        val comment1 = Comment(1,1,"1")
        service.addNote(note1)
        service.addComment(1,comment1)

        val result = note1.deleteComment(1)

        assertTrue(result)
    }

    @Test
    fun deleteComment_return_false() {

        val note1 = Note(1,"1","1")
        val service = NoteService()
        val comment1 = Comment(1,1,"1")
        service.addNote(note1)
        service.addComment(1,comment1)

        val result = note1.deleteComment(2)

        assertFalse(result)
    }

    @Test
    fun getAllComments_return_comment() {

        val note1 = Note(1,"1","1")
        val service = NoteService()
        val comment1 = Comment(1,1,"1")
        service.addNote(note1)
        service.addComment(1,comment1)

        val result = note1.getAllComments()

        assertNotNull(result)
    }

    @Test
    fun getAllComments_return_null() {

        val note1 = Note(1,"1","1")
        val service = NoteService()
        service.addNote(note1)

        val result = note1.getAllComments()

        assertNull(result)
    }

    @Test
    fun restoreComment_return_true() {

        val note1 = Note(1,"1","1")
        val service = NoteService()
        val comment1 = Comment(1,1,"1")
        service.addNote(note1)
        service.addComment(1,comment1)
        note1.deleteComment(1)
        val result = note1.restoreComment(1)

        assertTrue(result)
    }

    @Test
    fun restoreComment_return_false() {

        val note1 = Note(1,"1","1")
        val service = NoteService()
        val comment1 = Comment(1,1,"1")
        service.addNote(note1)
        service.addComment(1,comment1)
        note1.deleteComment(1)

        val result = note1.restoreComment(2)

        assertFalse(result)
    }
}