abstract class CrudService <E : CrudItem> {

    val list = mutableListOf<E>()
    var nextId = 1

    fun addNote (item: E): E {
        item.id = nextId++
        list.add(item)
        return list.last()
    }

    fun deleteNote (item: E): Boolean {
        if (list.contains(item)) {
           val tempNote = Note(0,"0","0")
            tempNote.deleteAllComment(item.id)
            list.remove(item)
            return true
        }
        return false
    }
    fun getNote (id: Int): E?{
        for(itemInList in list){
            if (id == itemInList.id) {
                return itemInList
            }
        }
        return null
    }

    fun updateNote (item: E): Boolean {
        for((index,noteInList) in list.withIndex()) {
            if (item.id == noteInList.id) {
                list.remove(noteInList)
                list.add(index, item)
                return true
            }
        }
        return false
    }

    fun getAllNotes (): E? {
        if (list.isNotEmpty()) {
            for (noteInList in list) {
                return noteInList
            }
        }
        return null
    }
}