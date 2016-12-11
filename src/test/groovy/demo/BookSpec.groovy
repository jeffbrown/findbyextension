package demo

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Book)
class BookSpec extends Specification {

    void "test extension method"() {
        setup:
        new Book(title: 'Pragmatic Programmer', author: 'Andy Hunt', pages: 320).save()

        when:
        def book = Book.findOrSaveWhere(title: 'Pragmatic Programmer', [author: 'Some New Author', pages: 999])

        then:
        book.id != null
        book.title == 'Pragmatic Programmer'
        book.author == 'Andy Hunt'
        book.pages == 320
        Book.count() == 1

        when:
        book = Book.findOrSaveWhere(title: 'Kotlin In Action', [author: 'Kotlin Ken', pages: 350])

        then:
        book.id != null
        book.title == 'Kotlin In Action'
        book.author == 'Kotlin Ken'
        book.pages == 350
        Book.count() == 2
    }
}
