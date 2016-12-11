package demo

class BookExtension {

    static Book findOrSaveWhere(final Book b, Map m1, Map m2) {
        // just a proof of concept...

        def book = Book.findOrCreateWhere(m1)

        if(book.id == null) {
            book.properties = m2
            book = book.save()
        }

        book
    }
}
