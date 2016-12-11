package demo

import grails.artefact.DomainClass
import grails.artefact.Enhances

@Enhances('Domain')
trait CustomFindOrSaveWhere {

    // has "Trait" in the name just so it doesn't collide with the ohter
    // implementation in this project that is being defined as an extension
    // method.
    static DomainClass findOrSaveWhereFromTrait(Map queryParameters, Map parametersForNewInstance) {
        // just a proof of concept...

        def instance = this.findOrCreateWhere(queryParameters)

        if(instance.id == null) {
            instance.properties = parametersForNewInstance
            instance = instance.save()
        }

        instance
    }
}
