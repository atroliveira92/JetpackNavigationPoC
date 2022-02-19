package com.venmo.features.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.venmo.commons.navigation.routers.AddCreditCardRouter
import com.venmo.commons.navigation.routers.CreditCardRouter
import com.venmo.commons.navigation.routers.SettingsRouter
import com.venmo.entities.User
import com.venmo.features.profile.databinding.FragmentProfileBinding
import org.koin.android.ext.android.inject

class ProfileFragment: Fragment() {
    private val creditCardRouter by inject<CreditCardRouter>()
    private val addCreditCardRouter by inject<AddCreditCardRouter>()
    private val settingsRouter by inject<SettingsRouter>()

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnMyCards.setOnClickListener {
            //findNavController().navigate(InternalDeepLink.goToCreditCard(User("1", "Arthur")))
            creditCardRouter.navigate(User("1", "Arthur"), findNavController())
        }

        binding.btnAddCards.setOnClickListener {
            addCreditCardRouter.navigate(findNavController())
        }

        binding.btnSettings.setOnClickListener {
            settingsRouter.navigate(childFragmentManager)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}