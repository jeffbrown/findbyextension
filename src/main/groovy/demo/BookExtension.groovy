package demo

class BookExtension {

    static Book findOrSaveWhere(final Book b, Map queryParameters, Map parametersForNewInstance) {
        // just a proof of concept...

        def book = Book.findOrCreateWhere(queryParameters)

        if(book.id == null) {
            book.properties = parametersForNewInstance
            book = book.save()
        }

        book
    }
}
