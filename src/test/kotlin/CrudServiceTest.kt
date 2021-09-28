import org.junit.Test
import org.junit.Assert.*

class CrudServiceTest {

    @Test
    fun deleteNote_return_true() {

        val note1 = Note(1,"1","1")
        val service = NoteService()
        service.addNote(note1)

        val result = service.deleteNote(note1)

        assertTrue(result)
    }

    @Test
    fun deleteNote_return_false() {

        val note1 = Note(1,"1","1")
        val note2 = Note(1,"1","1")
        val service = NoteService()
        service.addNote(note1)

        val result = service.deleteNote(note2)

        assertFalse(result)
    }

    @Test
    fun getNote_return_note() {

        val note1 = Note(1,"1","1")
        val service = NoteService()
        val comment1 = Comment(1,1,"1")
        service.addNote(note1)
        service.addComment(1,comment1)

        val result = service.getNote(1)

        assertNotNull(result)
    }

    @Test
    fun getNote_return_null() {

        val note1 = Note(1,"1","1")
        val service = NoteService()
        val comment1 = Comment(1,1,"1")
        service.addNote(note1)
        service.addComment(1,comment1)

        val result = service.getNote(2)

        assertNull(result)
    }

    @Test
    fun updateNote_return_true() {

        val note1 = Note(1,"1","1")
        val note2 = Note(1,"2","2")
        val service = NoteService()
        service.addNote(note1)

        val result = service.updateNote(note2)

        assertTrue(result)
    }

    @Test
    fun updateNote_return_false() {

        val note1 = Note(1,"1","1")
        val note2 = Note(2,"1","1")
        val service = NoteService()
        service.addNote(note1)

        val result = service.updateNote(note2)

        assertFalse(result)
    }

    @Test
    fun getAllNotes_return_true() {

        val note1 = Note(1,"1","1")
        val service = NoteService()
        service.addNote(note1)

        val result = service.getAllNotes()

        assertNotNull(result)
    }

    @Test
    fun getAllNotes_return_false() {

        val service = NoteService()

        val result = service.getAllNotes()

        assertNull(result)
    }
}