package fr.isen.rouveure.brainpwr.Login

data class User (val firstName: String? = null, val lastName: String? = null,
                 val address: String? = null, val email: String? = null) {
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
}

