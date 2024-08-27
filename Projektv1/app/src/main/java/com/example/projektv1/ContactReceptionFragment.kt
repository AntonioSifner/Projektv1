package com.example.projektv1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projektv1.databinding.FragmentReceptionBinding

class ContactReceptionFragment : Fragment() {

    private lateinit var contactReceptionBinding: FragmentReceptionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        contactReceptionBinding = FragmentReceptionBinding.inflate(inflater, container, false)
        //initializeUI()
        return contactReceptionBinding.root
    }


    companion object {
        fun newInstance(): ContactReceptionFragment {
            return ContactReceptionFragment()
        }

    }

}